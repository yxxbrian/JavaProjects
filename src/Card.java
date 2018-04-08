import java.util.Comparator;

/**
 * Created by Brian_PC on 2017/7/19.
 */

public class Card// implements Comparator<Card>
{

    public Card(CardType cardType,Integer cardNumber)
    {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }


    //Type
    public CardType getType() {
        return cardType;
    }

    private CardType cardType;


    //Number
    public Integer getNumber() {
        return cardNumber;
    }

    private Integer cardNumber;


    @Override
    public String toString()
    {
        return cardType.toString()+cardNumber.toString();
    }
    
}
