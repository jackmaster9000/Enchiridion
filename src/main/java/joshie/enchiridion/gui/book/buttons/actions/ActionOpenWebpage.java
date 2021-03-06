package joshie.enchiridion.gui.book.buttons.actions;

import joshie.enchiridion.api.book.IButtonAction;

import java.awt.*;
import java.net.URI;

public class ActionOpenWebpage extends AbstractAction {
    public String url;

    public ActionOpenWebpage() {
        super("web");
        this.url = "http://www.joshiejack.uk/";
    }

    @Override
    public IButtonAction copy() {
        ActionOpenWebpage action = new ActionOpenWebpage();
        action.url = url;
        copyAbstract(action);
        return action;
    }

    @Override
    public IButtonAction create() {
        return new ActionOpenWebpage();
    }

    @Override
    public boolean performAction() {
        try {
            Desktop.getDesktop().browse(new URI(url));
            return true;
        } catch (Exception e) {}

        return false;
    }
}
