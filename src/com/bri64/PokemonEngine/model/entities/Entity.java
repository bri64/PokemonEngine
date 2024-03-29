package com.bri64.PokemonEngine.model.entities;

import com.bri64.PokemonEngine.model.Gerializable;
import com.bri64.PokemonEngine.model.Renderable;
import com.bri64.PokemonEngine.model.behavior.Interaction;
import com.bri64.PokemonEngine.model.json.Entity_JSON;
import com.bri64.PokemonEngine.model.sprite.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

/**
 * Entity - a {@link Renderable} with {@link Interaction}(s)
 */
public class Entity extends Renderable implements Gerializable {

  protected String type;

  protected Sprite sprite;
  protected Interaction interactBehavior;
  protected Interaction stepBehavior;

  public Interaction getInteract() {
    return interactBehavior;
  }
  public Interaction getStep() {
    return stepBehavior;
  }

  public Entity(Entity_JSON json) {
    this.type = "entity";

    this.pos = json.getPos();
    this.interactBehavior = json.getInteractBehavior();
    this.stepBehavior = json.getStepBehavior();

    this.sprite = new Sprite(json.getSprite());
  }

  // Test constructor
  public Entity(int X, int Y, Sprite sprite, Interaction interactBehavior, Interaction stepBehavior) {
    this.type = "entity";

    this.sprite = sprite;
    this.interactBehavior = interactBehavior;
    this.stepBehavior = stepBehavior;

    this.pos = new Point2D(X, Y);
  }

  @Override
  public void init() {}

  public void interact() {
    if (interactBehavior != null) {
      interactBehavior.execute();
    }
  }

  public void step() {
    if (stepBehavior != null) {
      stepBehavior.execute();
    }
  }

  @Override
  public Image render() {
    return sprite.render();
  }
}
