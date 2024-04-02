package test.unit.testing;

public class Money {
	private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency)
    {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount()
    {
        return  fAmount;
    }

    public String currency()
    {
        return fCurrency;
    }

    // public Money add(Money money)
    // {
    //   return new Money(amount() + money.amount(), currency());
    // }
    
    // Correction de la méthode add
    public Money add(Money m)
    {
    	if(m.currency().equals(currency()))
    		return new Money(amount() + m.amount(), currency());
    	return new MoneyBag(this, m);
    }
    
    public boolean equals(Money money1, Money money2) {
    	return money1.equals(money2);
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

           Money otherMoney = (Money) object;

           return fAmount == otherMoney.fAmount && fCurrency.equals(otherMoney.fCurrency);
    }
}
