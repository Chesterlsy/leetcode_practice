/*
 * Copyright (c) 2023. Chester
 */
package com.chester.leetcode_practice.datastructures.graph;

import java.util.ArrayList;

/**
 * Graph stores an ArrayList of Vertices.
 * Each vertex stores all incident edges.
 * @param <V>
 * @param <E>
 */
class AdjacencyListGraph<V, E> implements Graph<V, E> {

    private final boolean isDirected;
    private ArrayList<Vertex<V>> vertices;

//    private ArrayList<Edge<E>> edges;

    private class InnerVertex<V> implements Vertex<V> {

        private V vx;

        private ArrayList<Edge<E>> out;
        private ArrayList<Edge<E>> in;

        public InnerVertex(V vx, boolean isDirected) {
            this.vx = vx;
            out = new ArrayList<>();
            if (isDirected) {
                in = new ArrayList<>();
            } else {
                in = out;
            }
        }

        @Override
        public V getElement() {
            return vx;
        }

        @Override
        public void setElement(V vx) {
            this.vx = vx;
        }

        public ArrayList<Edge<E>> getOut() {
            return out;
        }

        public ArrayList<Edge<E>> getIn() {
            return in;
        }
    }

    private class InnerEdge<E> implements Edge<E> {

        private E ex;
        private Vertex<V> out;

        private Vertex<V> in;


        public InnerEdge(E ex, Vertex<V> out, Vertex<V> in) {
            this.ex = ex;
            this.out = out;
            this.in = in;
        }

        @Override
        public E getElement() {
            return ex;
        }

        @Override
        public void setElement(E ex) {
            this.ex = ex;
        }

        public Vertex<V> getOut() {
            return out;
        }

        public Vertex<V> getIn() {
            return in;
        }
    }

    public AdjacencyListGraph(boolean isDirected) {
        this.isDirected = isDirected;
        vertices = new ArrayList<>();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public Iterable<Edge<E>> Edges() {
        ArrayList<Edge<E>> edges = new ArrayList<>();
        for (Vertex<V> v: vertices) {
            for (Edge<E> e: validateV(v).getOut()) {
                if (!edges.contains(e)) {
                    edges.add(e);
                }
            }
            if (isDirected) {
                for (Edge<E> e: validateV(v).getIn()) {
                    if (!edges.contains(e)) {
                        edges.add(e);
                    }
                }
            }
        }
        return edges;
    }

    @Override
    public int numEdges() {
        return ((ArrayList<Edge<E>>) Edges()).size();
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        InnerVertex<V> iu = validateV(u);
        InnerVertex<V> iv = validateV(v);
        for (Edge<E> e: iu.getOut()) {
            if (validateE(e).getIn() == v) {
                return e;
            }
        }
        return null;
    }


    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        return new Vertex[]{validateE(e).getIn(), validateE(e).getOut()};
    }

    @Override
    public Vertex<V> insertVertex(V vx) {
        return null;
    }

    @Override
    public Edge<E> insertEdge(E ex, Vertex<V> u, Vertex<V> v) {
        if (getEdge(u, v) != null) {
            InnerEdge<E> e = new InnerEdge<>(ex, u, v);
            validateV(u).getOut().add(e);
            validateV(v).getIn().add(e);
//            edges.add(e);
            return e;
        } else {
            throw new IllegalArgumentException("Edge from u to v exists");
        }
    }

    @Override
    public void removeVertex(Vertex<V> v) {

    }

    @Override
    public void removeEdge(Edge<E> e) {

    }

    private InnerVertex<V> validateV(Vertex<V> v) {
        if (!(v instanceof InnerVertex<V>)) {
            throw new IllegalArgumentException();
        }
        return (InnerVertex<V>) v;
    }

    private InnerEdge<E> validateE(Edge<E> e) {
        if (!(e instanceof InnerEdge<E>)) {
            throw new IllegalArgumentException();
        }
        return (InnerEdge<E>) e;
    }
}
