package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P03Test {

  @Test
  public void testSerialize() {
    assertEquals(P03.serialize(new P03.Node("root")), "Node('root',|,|)");

    P03.Node node = new P03.Node("root", new P03.Node("left", new P03.Node("left.left")), new P03.Node("right"));

    System.out.println(P03.serialize(node));
    assertEquals(P03.serialize(node), "Node('root',Node('left',Node('left.left',|,|),|),Node('right',|,|))");
  }

  @Test
  public void testSerializeDeserialize() {
    P03.Node node = new P03.Node("root");
    assertEquals(P03.deserialize(P03.serialize(node)), node);

    node = new P03.Node("root", new P03.Node("left"), new P03.Node("right"));
    assertEquals(P03.deserialize(P03.serialize(node)), node);

    // Node('root', Node('left', Node('left.left')), Node('right'))
    node = new P03.Node("root", new P03.Node("left", new P03.Node("left.left")), new P03.Node("right"));
    assertEquals(P03.deserialize(P03.serialize(node)).getLeft().getLeft().getValue(), "left.left");
  }
}
