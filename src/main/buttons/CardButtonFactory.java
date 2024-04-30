package main.buttons;

import main.cards.DragonCard;

public class CardButtonFactory {
    public static CardButton createCardButton(String type, DragonCard card) {
        return switch (type) {
            case "BabyDragon" -> new BabyDragonCardButton(card);
            case "TwoBabyDragon" -> new TwoBabyDragonCardButton(card);
            case "ThreeBabyDragon" -> new ThreeBabyDragonCardButton(card);
            case "Salamander" -> new SalamanderCardButton(card);
            case "TwoSalamander" -> new TwoSalamanderCardButton(card);
            case "ThreeSalamander"-> new ThreeSalamanderCardButton(card);
            case "Bat" -> new BatCardButton(card);
            case "TwoBat" -> new TwoBatCardButton(card);
            case "ThreeBat"-> new ThreeBatCardButton(card);
            case "Spider" -> new SpiderCardButton(card);
            case "TwoSpider" -> new TwoSpiderCardButton(card);
            case "ThreeSpider"-> new ThreeSpiderCardButton(card);
            case "Pirate" -> new PirateCardButton(card);
            case "TwoPirate" -> new TwoPirateCardButton(card);
            default -> throw new IllegalArgumentException("Invalid type: " + type);
        };
    }
}
