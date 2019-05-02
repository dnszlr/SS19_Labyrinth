package Backend.Figure;

import java.util.ArrayList;
import java.util.Arrays;

import Backend.Color;
import Backend.Cards.ObjectCard;

public class Figure {

	/**
	 * Attribute der Klasse Figure
	 */
	private String name;
	private int[] pos;
	private Color color;
	private ObjectCard treasureCard;
	private CardsStack cardstack;

	/**
	 * Konstruktor der Klasse Figure.
	 * 
	 * @param name
	 * @param color
	 */

	public Figure(String name, Color color) {

		this.cardstack = new CardsStack();
		this.name = name;
		this.color = color;
	}

	/**
	 * Konstruktor der Klasse Figure.
	 * 
	 * @param name
	 * @param color
	 * @param pos
	 */

	public Figure(String name, Color color, int[] pos) {

		this.cardstack = new CardsStack();
		this.name = name;
		this.color = color;
		this.setPos(pos);
	}

	/**
	 * Getter f�r das Attribut name.
	 * 
	 * @return
	 */

	public String getName() {

		return this.name;
	}

	/**
	 * Getter f�r das Attribut color.
	 * 
	 * @return
	 */

	public Color getColor() {

		return this.color;
	}

	/**
	 * Getter f�r das Attribut treasureCard.
	 * 
	 * @return
	 */

	public ObjectCard getTreasureCard() {

		return this.treasureCard;
	}

	/**
	 * Getter f�r das Attribut pos.
	 * 
	 * @return
	 */

	public int[] getPos() {

		return this.pos;
	}

	/**
	 * Getter f�r die gefundenen Karten.
	 * 
	 * @return
	 */

	public String getFoundCards() {

		return null;
	}

	/**
	 * Setter f�r das Attribut pos.
	 * 
	 * @param pos
	 */

	public void setPos(int[] pos) {

		this.pos = pos;

	}

	/**
	 * Methode um eine Karte hinzuzuf�gen.
	 * 
	 * @param card
	 */
	public void addCard(ObjectCard card) {

		cardstack.addCard(card);

	}

	/**
	 * Methode um eine Karte zu ziehen.
	 * 
	 * @return
	 */

	public ObjectCard drawCard() {

		return cardstack.drawCard();
	}

	/**
	 * Methode um abzufragen ob eine Karte gefunden wurde.
	 * 
	 * @param card
	 * @return
	 */

	public boolean isFound(ObjectCard card) {
		
		return cardstack.cardFound(card);

	}

	/**
	 * Methode um herauszufinden ob alle Karten gefunden wurden
	 * 
	 * @return
	 */

	public boolean isAllFound() {

		return cardstack.isAllFound();

	}

	/**
	 * �berschreiben der Object Methode "toString". Umwandlung des Objektes in einen
	 * String.
	 */

	@Override
	public String toString() {
		return null;
	}

	/**
	 * Innere Klasse CardsStack
	 */
	private class CardsStack {

		/**
		 * Attribute der Klasse CardsStack
		 */
		private ArrayList<ObjectCard> foundCards;
		private ArrayList<ObjectCard> objectsCards;

		/**
		 * Konstruktor f�r die Klasse CardsStack
		 */

		private CardsStack() {

		}

		/**
		 * Methode um eine Karte dem CardStack hinzuzuf�gen
		 * 
		 * @param card
		 */

		private void addCard(ObjectCard card) {

			objectsCards.add(card);
		}

		/**
		 * Methode um eine Karte vom CardStack zu ziehen.
		 * 
		 * @return
		 */

		private ObjectCard drawCard() {

			ObjectCard drawCard = objectsCards.get(0);
			objectsCards.remove(0);
			return drawCard;
		}

		/**
		 * Methode um zu �berpr�fen ob eine Karte gefunden wurde.
		 * 
		 * @param card
		 * @return
		 */

		private boolean cardFound(ObjectCard card) {
			boolean result = false;
			for (ObjectCard i : objectsCards) {
				if (result == false) {
					if (i.equals(card)) {
						foundCards.add(i);
						objectsCards.remove(i);
						result = true;
					}
				}
			}
			return result;
		}

		/**
		 * Methode um zu �berpr�fen ob alle Karten gefunden wurde
		 * 
		 * @return
		 */

		private boolean isAllFound() {
			boolean result = false;
			if (objectsCards.size() == 0) {
				result = true;
			}
			return result;
		}

		/**
		 * �berschreiben der Object Methode "toString". Umwandlung des Objektes in einen
		 * String.
		 */

		@Override
		public String toString() {

			return null;
		}

	}

}
