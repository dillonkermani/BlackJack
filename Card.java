package CardGame;


/**
 * Write a description of class Cards here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
    {
    private String face;
    private String suit;
    private int value;
public Card (String cardFace, String cardSuit)
{
    face = cardFace;
    suit = cardSuit;
    if(face.equals("Ace"))
    {
        value = 1;
    }
    if(face.equals("Deuce"))
    value = 2;
    if(face.equals("Three"))
    value = 3;
    if(face.equals("Four"))
    value = 4;
    if(face.equals("Five"))
    value = 5;
    if(face.equals("Six"))
    value = 6;
    if(face.equals("Seven"))
    value = 7;
    if(face.equals("Eight"))
    value = 8;
    if(face.equals("Nine"))
    value = 9;
    if(face.equals( "Ten" ) || face.equals("Jack") || face.equals("Queen") || 
    face.equals("King" ))
    value = 10;

}
public String toString()
{
    return face + " of " + suit;
}
public int getValue()
{
    return value;
    }
    public void changeValue(int v)
    {
        value += v;
    }
    public String getName()
    {
        return face;
    }
}
