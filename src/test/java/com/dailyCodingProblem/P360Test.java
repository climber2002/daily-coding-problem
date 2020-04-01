package com.dailyCodingProblem;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class P360Test {
  private Set<Integer[]> playlists;

  @Before
  public void before() {
    this.playlists = new HashSet<>();
    playlists.add(new Integer[] { 1, 7, 3 });
    playlists.add(new Integer[] { 2, 1, 6, 7, 9 });
    playlists.add(new Integer[] { 3, 9, 5 });
  }

  @Test
  public void testCreateGraph() {
    P360.Graph graph = new P360.Graph(playlists);
    assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3, 5, 6, 7, 9)), graph.getVertices());
    assertEquals(7, graph.getEdges().size());
    assertEquals(new HashSet<>(Arrays.asList(7, 6)), graph.getEdgesForVertex(1));
    assertEquals(new HashSet<>(Arrays.asList(3, 9)), graph.getEdgesForVertex(7));
  }

  @Test
  public void testSortPlaylists() {
    Integer[] result = P360.sortPlaylists(playlists);
    assertArrayEquals(new Integer[] { 2, 1, 6, 7, 3, 9, 5 }, result);
  }
}
