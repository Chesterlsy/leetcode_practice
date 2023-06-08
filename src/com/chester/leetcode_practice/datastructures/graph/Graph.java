/*
 * Copyright (c) 2023. Chester
 */

package com.chester.leetcode_practice.datastructures.graph;


/**
 * Author: Chester
 * Date: 05/07/2019
 * TIME: 23:51
 * Description:
 */
interface Graph<V, E> {

    interface Vertex<V> {
        V getElement();

        void setElement(V vx);

//        Iterable<Edge<?>> getOut();
//        Iterable<Edge<?>> getIn();
    }

    interface Edge<E> {
        E getElement();

        void setElement(E ex);
//        Vertex<?> getOut();
//
//        Vertex<?> getIn();
    }

    /**
     *
     * @return an iteration of all the vertices of the graph
     */
    Iterable<Vertex<V>> vertices();

    /**
     *
     * @return the number of vertices of the graph
     */
    int numVertices();

    /**
     *
     * @return an iteration of all the edges of the graph
     */
    Iterable<Edge<E>> Edges();

    /**
     *
     * @return the number of edges of the graph
     */
    int numEdges();

    /**
     * Returns the edge from vertex u to vertex v, if one exists;
     * otherwise return null. For an undirected graph, there is no
     * difference between getEdge(u, v) and getEdge(v, u).
     * @param u
     * @param v
     * @return the edge from vertex u to vertex v, if one exists; otherwise return null
     */
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v);

    /**
     * If the graph is directed, the first vertex is the origin
     * and the second is the destination.
     * @param e the edge
     * @return an array containing the two endpoint vertices of edge e.
     */
    Vertex<V>[] endVertices(Edge<E> e);

    /**
     * Creates and returns a new Vertex storing element vx.
     * @param vx element to be stored in added vertex
     * @return vertex added
     */
    Vertex<V> insertVertex(V vx);

    /**
     * Creates and returns a new Edge from vertex u to vertex v,
     * storing element ex; an error occurs if there already exists an
     * edge from u to v.
     * @param ex
     * @param u
     * @param v
     * @return edge added
     */
    Edge<E> insertEdge(E ex, Vertex<V> u, Vertex<V> v);

    /**
     * Removes vertex v and all its incident edges from the graph
     * @param v
     */
    void removeVertex(Vertex<V> v);

    /**
     * Removes edge e from the graph
     * @param e
     */
    void removeEdge(Edge<E> e);
}
