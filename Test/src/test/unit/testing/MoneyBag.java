package test.unit.testing;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class MoneyBag implements IMoney {
    private Vector<Money> fMonies = new Vector<Money>();

    MoneyBag (Money m1, Money m2){
        appendMoney(m1);
        appendMoney(m2);
    }

    MoneyBag (Money bag[]){
        for (int i = 0; i < bag.length; i++)
            appendMoney(bag[i]);
    }
    
    public IMoney add(IMoney m)
    {
    	return ((MoneyBag) m).addMoneyBag(this);
    }


    public MoneyBag addMoneyBag(MoneyBag bag) {
        for(Money money : bag.fMonies)
        {
        	appendMoney(money);
        }
        return this;
    }
    
    
    private void appendMoney(Money m){
        if(fMonies.isEmpty())
        {
            fMonies.add(m);
        }
        else 
        {
            int i = 0;
            while ((i < fMonies.size()) 
                    && (! (fMonies.get(i).currency().equals(m.currency()))))
                i++;

            if (i >= fMonies.size())
            {
                fMonies.add(m);
            }
            else 
            {
                fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
            }

        }
    }

    @Override
	public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }

        if (object == null || getClass() != object.getClass())
        {
            return false;
        }

        MoneyBag otherMoneyBag = (MoneyBag) object;

     // Check if the sizes of the fMonies vectors are the same
        if(fMonies.size() != otherMoneyBag.fMonies.size())
        {
        	return false;
        }
        
     // Create copies of the vectors to avoid modifying the originals

        Vector<Money> thisMonies = new Vector<>(fMonies);
        Vector<Money> otherMonies = new Vector<>(otherMoneyBag.fMonies);
        
        // Sort the vectors to ensure consistent comparison
        Collections.sort(thisMonies, Comparator.comparing(Money::currency));
        Collections.sort(otherMonies, Comparator.comparing(Money::currency));
        
     // Compare each Money object in the vectors
        for(int i = 0; i < thisMonies.size(); i++)
        {
        	Money thisMoney = thisMonies.get(i);
        	Money otherMoney = otherMonies.get(i);
        	if(!thisMoney.equals(otherMoney)) {
        		return false;
        	}
        }
        return true;
        		
    }
}