package app.freerouting.gui;

import app.freerouting.management.TextManager;
import app.freerouting.management.analytics.FRAnalytics;

import javax.swing.*;

/**
 * Creates the display menu of a board frame.
 */
public class BoardMenuDisplay extends JMenu
{
  private final BoardFrame board_frame;
  private final TextManager tm;

  /**
   * Creates a new instance of BoardDisplayMenu
   */
  private BoardMenuDisplay(BoardFrame p_board_frame)
  {
    board_frame = p_board_frame;
    tm = new TextManager(this.getClass(), p_board_frame.get_locale());
  }

  /**
   * Returns a new display menu for the board frame.
   */
  public static BoardMenuDisplay get_instance(BoardFrame p_board_frame)
  {
    final BoardMenuDisplay display_menu = new BoardMenuDisplay(p_board_frame);
    display_menu.setText(display_menu.tm.getText("display"));

    JMenuItem display_object_visibility_menuitem = new JMenuItem();
    display_object_visibility_menuitem.setText(display_menu.tm.getText("object_visibility"));
    display_object_visibility_menuitem.setToolTipText(display_menu.tm.getText("object_visibility_tooltip"));
    display_object_visibility_menuitem.addActionListener(evt -> display_menu.board_frame.object_visibility_window.setVisible(true));
    display_object_visibility_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("display_object_visibility_menuitem", display_object_visibility_menuitem.getText()));

    display_menu.add(display_object_visibility_menuitem);

    JMenuItem display_layer_visibility_menuitem = new JMenuItem();
    display_layer_visibility_menuitem.setText(display_menu.tm.getText("layer_visibility"));
    display_layer_visibility_menuitem.setToolTipText(display_menu.tm.getText("layer_visibility_tooltip"));
    display_layer_visibility_menuitem.addActionListener(evt -> display_menu.board_frame.layer_visibility_window.setVisible(true));
    display_layer_visibility_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("display_layer_visibility_menuitem", display_layer_visibility_menuitem.getText()));

    display_menu.add(display_layer_visibility_menuitem);

    JMenuItem display_colors_menuitem = new JMenuItem();
    display_colors_menuitem.setText(display_menu.tm.getText("colors"));
    display_colors_menuitem.setToolTipText(display_menu.tm.getText("colors_tooltip"));
    display_colors_menuitem.addActionListener(evt -> display_menu.board_frame.color_manager.setVisible(true));
    display_colors_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("display_colors_menuitem", display_colors_menuitem.getText()));

    display_menu.add(display_colors_menuitem);

    JMenuItem display_miscellaneous_menuitem = new JMenuItem();
    display_miscellaneous_menuitem.setText(display_menu.tm.getText("miscellaneous"));
    display_miscellaneous_menuitem.addActionListener(evt -> display_menu.board_frame.display_misc_window.setVisible(true));
    display_miscellaneous_menuitem.addActionListener(evt -> FRAnalytics.buttonClicked("display_miscellaneous_menuitem", display_miscellaneous_menuitem.getText()));

    display_menu.add(display_miscellaneous_menuitem);

    return display_menu;
  }
}