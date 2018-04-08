import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        String firstPlayer = "PC";
        String secondPlayer = "User";
        ArrayList<Card> CardsOfPC = CardFactory.produceCards(5);
        ArrayList<Card> CardsOfUser = CardFactory.produceCards(5);

        PrintCards("PC cards:",CardsOfPC);
        PrintCards("User cards:",CardsOfUser);

        CardArrayComparer comparer = new CardArrayComparer();
        int result = comparer.Compare(CardsOfPC,CardsOfUser);
        PrintResult(firstPlayer,secondPlayer,result);
    }

    private static void PrintResult(String firstName,String secondName,int result)
    {
        if(result == 1)
        {
            System.out.println("Winner is "+firstName);
        }
        else if(result == -1)
        {
            System.out.println("Winner is "+secondName);
        }
        else if(result == 0)
        {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Invalid Input!");
        }
    }


    private static void PrintCards(String name,ArrayList<Card> cards)
    {
        System.out.print(name+" ");
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i)+" ");
        }
        System.out.println();
    }


    //Test
    @Test
    public void Test_23556_sameWith_23556() {
        ArrayList<Card> CardsOfPC = new ArrayList<Card>();
        ArrayList<Card> CardsOfUser = new ArrayList<Card>();
        Card card0 = new Card(CardType.A, 2);
        Card card1 = new Card(CardType.A, 3);
        Card card2 = new Card(CardType.A, 5);
        Card card3 = new Card(CardType.A, 5);
        Card card4 = new Card(CardType.A, 6);
        CardsOfPC.add(card0);
        CardsOfPC.add(card1);
        CardsOfPC.add(card2);
        CardsOfPC.add(card3);
        CardsOfPC.add(card4);

        Card card5 = new Card(CardType.A, 2);
        Card card6 = new Card(CardType.A, 3);
        Card card7 = new Card(CardType.A, 5);
        Card card8 = new Card(CardType.A, 5);
        Card card9 = new Card(CardType.A, 6);
        CardsOfUser.add(card5);
        CardsOfUser.add(card6);
        CardsOfUser.add(card7);
        CardsOfUser.add(card8);
        CardsOfUser.add(card9);

        CardArrayComparer comparer = new CardArrayComparer();
        int result = comparer.Compare(CardsOfPC,CardsOfUser);
        Assert.assertTrue(result == 0);
    }



    @Test
    public void Test_B11_A2_A9_D10_A8_smallerThan_D4_A4_C10_C6_B11() {
        ArrayList<Card> CardsOfPC = new ArrayList<Card>();
        ArrayList<Card> CardsOfUser = new ArrayList<Card>();
        Card card0 = new Card(CardType.B, 11);
        Card card1 = new Card(CardType.A, 2);
        Card card2 = new Card(CardType.A, 9);
        Card card3 = new Card(CardType.D, 10);
        Card card4 = new Card(CardType.A, 8);
        CardsOfPC.add(card0);
        CardsOfPC.add(card1);
        CardsOfPC.add(card2);
        CardsOfPC.add(card3);
        CardsOfPC.add(card4);

        Card card5 = new Card(CardType.D, 4);
        Card card6 = new Card(CardType.A, 4);
        Card card7 = new Card(CardType.C, 10);
        Card card8 = new Card(CardType.C, 6);
        Card card9 = new Card(CardType.B, 11);
        CardsOfUser.add(card5);
        CardsOfUser.add(card6);
        CardsOfUser.add(card7);
        CardsOfUser.add(card8);
        CardsOfUser.add(card9);

        CardArrayComparer comparer = new CardArrayComparer();
        int result = comparer.Compare(CardsOfPC,CardsOfUser);
        Assert.assertTrue(result == -1);
    }


    @Test
    public void Test_B11_A2_A9_D10_A8_biggerThan_D4_A8_C10_C6_B11() {
        ArrayList<Card> CardsOfPC = new ArrayList<Card>();
        ArrayList<Card> CardsOfUser = new ArrayList<Card>();
        Card card0 = new Card(CardType.B, 11);
        Card card1 = new Card(CardType.A, 2);
        Card card2 = new Card(CardType.A, 9);
        Card card3 = new Card(CardType.D, 10);
        Card card4 = new Card(CardType.A, 8);
        CardsOfPC.add(card0);
        CardsOfPC.add(card1);
        CardsOfPC.add(card2);
        CardsOfPC.add(card3);
        CardsOfPC.add(card4);

        Card card5 = new Card(CardType.D, 4);
        Card card6 = new Card(CardType.A, 8);
        Card card7 = new Card(CardType.C, 10);
        Card card8 = new Card(CardType.C, 6);
        Card card9 = new Card(CardType.B, 11);
        CardsOfUser.add(card5);
        CardsOfUser.add(card6);
        CardsOfUser.add(card7);
        CardsOfUser.add(card8);
        CardsOfUser.add(card9);

        CardArrayComparer comparer = new CardArrayComparer();
        int result = comparer.Compare(CardsOfPC,CardsOfUser);
        Assert.assertTrue(result == 1);
    }



}
