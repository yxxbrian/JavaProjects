import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brian_PC on 2017/7/19.
 */
public class CardFactory {


    public static ArrayList<Card> produceCards(int count)
    {
        ArrayList<Card> result = new ArrayList<Card>();
        ArrayList<Card> cardRepository = createCardRepository();
        for (int i=0;i<count;i++)
        {
            Random random = new Random();
            int curSelectedIndex = random.nextInt(cardRepository.size());
            result.add(cardRepository.get(curSelectedIndex));
            cardRepository.remove(curSelectedIndex);
        }
        return  result;

    }

    private static ArrayList<Card> createCardRepository()
    {
        ArrayList<Card> cardRepository = new ArrayList<Card>();

        //initialzie cardTypes
        ArrayList<CardType> cardTypes = new ArrayList<CardType>();
        cardTypes.add(CardType.A);
        cardTypes.add(CardType.B);
        cardTypes.add(CardType.C);
        cardTypes.add(CardType.D);

        //initialize cardNumbers
        ArrayList<Integer> cardNumbers = new ArrayList<Integer>();
        for (int i = 2; i <= 14; i++) {
            cardNumbers.add(i);
        }

        for(CardType cardType : cardTypes)
            for (Integer cardNum : cardNumbers)
            {
                Card card = new Card(cardType,cardNum);
                cardRepository.add(card);
            }
        return  cardRepository;

    }



}
