package util.managers;

import util.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class ImageManager {

    private static ImageManager instance;

    private final ImageCache imageCache;

    private ImageManager() {

        imageCache = ImageCache.getInstance();
        initImages();
    }

    private void initImages() {

        addPanels();
        addHolders();
        addTabs();
        addPlayerElements();
        addButtons();
        //Characters
        imageCache.addImage("portrait",
                new ImageIcon("img\\player\\portrait.png").getImage());
    }

    private void addButtons() {
        //Buttons
        imageCache.addImage("attackButtonIdle",
                new ImageIcon("img\\ui\\buttons\\attackButtonIdle.png").getImage());
        imageCache.addImage("attackButtonHover",
                new ImageIcon("img\\ui\\buttons\\attackButtonHover.png").getImage());
        imageCache.addImage("fleeButtonIdle",
                new ImageIcon("img\\ui\\buttons\\fleeButtonIdle.png").getImage());
        imageCache.addImage("fleeButtonHover",
                new ImageIcon("img\\ui\\buttons\\fleeButtonHover.png").getImage());
        imageCache.addImage("skillButtonIdle",
                new ImageIcon("img\\ui\\buttons\\skillButtonIdle.png").getImage());
        imageCache.addImage("skillButtonHover",
                new ImageIcon("img\\ui\\buttons\\skillButtonHover.png").getImage());
    }

    private void addPlayerElements() {
        //Player Elements
        imageCache.addImage("mp100", new ImageIcon("img\\player\\mp100.png").getImage());
        imageCache.addImage("mp80", new ImageIcon("img\\player\\mp80.png").getImage());
        imageCache.addImage("mp60", new ImageIcon("img\\player\\mp60.png").getImage());
        imageCache.addImage("mp40", new ImageIcon("img\\player\\mp40.png").getImage());
        imageCache.addImage("mp20", new ImageIcon("img\\player\\mp20.png").getImage());
        imageCache.addImage("mp0", new ImageIcon("img\\player\\mp0.png").getImage());
        imageCache.addImage("hp100", new ImageIcon("img\\player\\hp100.png").getImage());
        imageCache.addImage("hp80", new ImageIcon("img\\player\\hp80.png").getImage());
        imageCache.addImage("hp60", new ImageIcon("img\\player\\hp60.png").getImage());
        imageCache.addImage("hp40", new ImageIcon("img\\player\\hp40.png").getImage());
        imageCache.addImage("hp20", new ImageIcon("img\\player\\hp20.png").getImage());
        imageCache.addImage("hp0", new ImageIcon("img\\player\\hp0.png").getImage());
    }

    private void addTabs() {
        //Tabs
        imageCache.addImage("battleTabActive",
                new ImageIcon("img\\ui\\tabs\\battleTabActive.png").getImage());
        imageCache.addImage("battleTabInactive",
                new ImageIcon("img\\ui\\tabs\\battleTabInactive.png").getImage());
        imageCache.addImage("InventoryTabActive",
                new ImageIcon("img\\ui\\tabs\\inventoryTabActive.png").getImage());
        imageCache.addImage("InventoryTabInactive",
                new ImageIcon("img\\ui\\tabs\\inventoryTabInactive.png").getImage());
        imageCache.addImage("statusTabActive",
                new ImageIcon("img\\ui\\tabs\\statusTabActive.png").getImage());
        imageCache.addImage("statusTabInactive",
                new ImageIcon("img\\ui\\tabs\\statusTabInactive.png").getImage());
    }

    private void addHolders() {
        //Holders
        imageCache.addImage("expHolder",
                new ImageIcon("img\\ui\\holders\\expHolder.png").getImage());
        imageCache.addImage("attackHolder",
                new ImageIcon("img\\ui\\holders\\attackHolder.png").getImage());
        imageCache.addImage("defenseHolder",
                new ImageIcon("img\\ui\\holders\\defenseHolder.png").getImage());
        imageCache.addImage("goldHolder",
                new ImageIcon("img\\ui\\holders\\goldHolder.png").getImage());
        imageCache.addImage("dexterityHolder",
                new ImageIcon("img\\ui\\holders\\dexterityHolder.png").getImage());
        imageCache.addImage("intelligenceHolder",
                new ImageIcon("img\\ui\\holders\\intHolder.png").getImage());
        imageCache.addImage("luckHolder",
                new ImageIcon("img\\ui\\holders\\lukHolder.png").getImage());
        imageCache.addImage("headArmorHolder",
                new ImageIcon("img\\ui\\holders\\headArmorHolder.png").getImage());
        imageCache.addImage("chestArmorHolder",
                new ImageIcon("img\\ui\\holders\\chestArmorHolder.png").getImage());
        imageCache.addImage("legArmorHolder",
                new ImageIcon("img\\ui\\holders\\legArmorHolder.png").getImage());
        imageCache.addImage("feetArmorHolder",
                new ImageIcon("img\\ui\\holders\\feetArmorHolder.png").getImage());
        imageCache.addImage("handArmorHolder",
                new ImageIcon("img\\ui\\holders\\handArmorHolder.png").getImage());
        imageCache.addImage("resHolder",
                new ImageIcon("img\\ui\\holders\\resHolder.png").getImage());
        imageCache.addImage("velHolder",
                new ImageIcon("img\\ui\\holders\\velHolder.png").getImage());
        imageCache.addImage("weaponHolder",
                new ImageIcon("img\\ui\\holders\\weaponHolder.png").getImage());
        imageCache.addImage("textHolder",
                new ImageIcon("img\\ui\\holders\\textHolder.png").getImage());
        imageCache.addImage("jobHolder",
                new ImageIcon("img\\ui\\holders\\jobHolder.png").getImage());
    }

    private void addPanels() {
        //Paneles
        imageCache.addImage("statusPanel",
                new ImageIcon("img\\ui\\panels\\statusPanel.png").getImage());
        imageCache.addImage("playerPanel",
                new ImageIcon("img\\ui\\panels\\playerPanel.png").getImage());
        imageCache.addImage("enemyPanel",
                new ImageIcon("img\\ui\\panels\\enemyPanel.png").getImage());
        imageCache.addImage("battlePanel",
                new ImageIcon("img\\ui\\panels\\battlePanel.png").getImage());
        imageCache.addImage("charactersPanel",
                new ImageIcon("img\\ui\\panels\\charactersPanel.png").getImage());
        imageCache.addImage("skillPanel",
                new ImageIcon("img\\ui\\panels\\skillPanel.png").getImage());
        imageCache.addImage("dialogPanel",
                new ImageIcon("img\\ui\\panels\\dialogPanel.png").getImage());
        imageCache.addImage("skillDetailPanel",
                new ImageIcon("img\\ui\\panels\\skillDetailPanel.png").getImage());
        imageCache.addImage("consolePanel",
                new ImageIcon("img\\ui\\panels\\consolePanel.png").getImage());
        imageCache.addImage("ssPanels",
                new ImageIcon("img\\ui\\panels\\ssPanels.png").getImage());
        imageCache.addImage("ssPanels2",
                new ImageIcon("img\\ui\\panels\\ssPanels2.png").getImage());
        imageCache.addImage("gamePanel",
                new ImageIcon("img\\ui\\panels\\gamePanel.png").getImage());
        imageCache.addImage("buttonsPanel",
                new ImageIcon("img\\ui\\panels\\buttonsPanel.png").getImage());
        imageCache.addImage("filescreen",
                new ImageIcon("img\\ui\\panels\\SlotsLabel.png").getImage());
        imageCache.addImage("inventario",
                new ImageIcon("img\\ui\\buttons\\inventarioButton.png").getImage());
        imageCache.addImage("salir",
                new ImageIcon("img\\ui\\buttons\\salirButton.png").getImage());
        imageCache.addImage("pelear",
                new ImageIcon("img\\ui\\buttons\\pelearButton.png").getImage());
        imageCache.addImage("ataque",
                new ImageIcon("img\\ui\\buttons\\ataqueButton.png").getImage());
        imageCache.addImage("libra",
                new ImageIcon("img\\ui\\buttons\\libraButton.png").getImage());
        imageCache.addImage("huir",
                new ImageIcon("img\\ui\\buttons\\HuirButton.png").getImage());
        imageCache.addImage("golpe",
                new ImageIcon("img\\ui\\buttons\\golpeButton.png").getImage());
        imageCache.addImage("artilleria",
                new ImageIcon("img\\ui\\buttons\\artilleriaButton.png").getImage());
        imageCache.addImage("regresar",
                new ImageIcon("img\\ui\\buttons\\regresarButton.png").getImage());
        imageCache.addImage("aNormal",
                new ImageIcon("img\\ui\\buttons\\normalButton.png").getImage());
        imageCache.addImage("aCargado",
                new ImageIcon("img\\ui\\buttons\\cargadoButton.png").getImage());
        imageCache.addImage("statsBActive",
                new ImageIcon("img\\ui\\buttons\\estadisticasButtonActive.png").getImage());
        imageCache.addImage("statsBInactive",
                new ImageIcon("img\\ui\\buttons\\estadisticasButtonInactive.png").getImage());
        imageCache.addImage("statusBActive",
                new ImageIcon("img\\ui\\buttons\\estatusbuttonActive.png").getImage());
        imageCache.addImage("statusBInactive",
                new ImageIcon("img\\ui\\buttons\\estatusbuttoninactive.png").getImage());
        imageCache.addImage("hpEnemy",
                new ImageIcon("img\\enemies\\hp100enemies.png").getImage());
        imageCache.addImage("hongjoog",
                new ImageIcon("img\\enemies\\Hongjoog.png").getImage());
        imageCache.addImage("jonho",
                new ImageIcon("img\\enemies\\Jonho.png").getImage());
        imageCache.addImage("mingi",
                new ImageIcon("img\\enemies\\Mingi.png").getImage());
        imageCache.addImage("san",
                new ImageIcon("img\\enemies\\San.png").getImage());
        imageCache.addImage("seonhwa",
                new ImageIcon("img\\enemies\\Seonhwa.png").getImage());
        imageCache.addImage("wooyoung",
                new ImageIcon("img\\enemies\\Wooyoung.png").getImage());
        imageCache.addImage("yeosang",
                new ImageIcon("img\\enemies\\Yeosang.png").getImage());
        imageCache.addImage("yunho",
                new ImageIcon("img\\enemies\\Yunho.png").getImage());
        imageCache.addImage("slot1",
                new ImageIcon("img\\ui\\holders\\slot1.png").getImage());
        imageCache.addImage("slot2",
                new ImageIcon("img\\ui\\holders\\slot2.png").getImage());
        imageCache.addImage("slot3",
                new ImageIcon("img\\ui\\holders\\slot3.png").getImage());
        imageCache.addImage("logo",
                new ImageIcon("img\\Logo.png").getImage());
        imageCache.addImage("icono",
                new ImageIcon("img\\icono.png").getImage());
        imageCache.addImage("equipar",
                new ImageIcon("img\\ui\\buttons\\equiparbutton.png").getImage());
        imageCache.addImage("tienda",
                new ImageIcon("img\\ui\\buttons\\tiendabutton.png").getImage());
        imageCache.addImage("armadura",
                new ImageIcon("img\\ui\\buttons\\armadurabutton.png").getImage());
        imageCache.addImage("arma",
                new ImageIcon("img\\ui\\buttons\\armabutton.png").getImage());
        imageCache.addImage("comprar",
                new ImageIcon("img\\ui\\buttons\\comprarButton.png").getImage());
        imageCache.addImage("vender",
                new ImageIcon("img\\ui\\buttons\\venderButton.png").getImage());
    }

    public static ImageManager getInstance() {

        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }

    public Image getImage(String imageName) {

        return imageCache.getImage(imageName);
    }

    public Image getImage(String imageName, Image image) {

        if (imageCache.getImage(imageName) == null) {
            imageCache.addImage(imageName, image);
            return image;
        } else
            return imageCache.getImage(imageName);
    }
}
