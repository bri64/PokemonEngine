package com.bri64.PokemonEngine.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Renderable {

  protected Point2D pos;

  public Point2D getPos() {
    return pos;
  }
  protected void setPos(double x, double y) {
    pos = new Point2D(x, y);
  }
  protected void movePos(final double x, final double y) {
    pos = pos.add(x, y);
  }

  abstract public Image render();
}

