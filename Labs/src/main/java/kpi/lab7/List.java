package kpi.lab7;

import java.util.ArrayList;

public class List<T> {
    private java.util.List<T> list;

    List() {
        list = new ArrayList<>();
    }

    List<T> add(T element) {
        list.add(element);
        return this;
    }

    List<T> shift2Right(int n) {
        if (n > 0 && size() <= n) {
            System.out.println("Error");
            return null;
        }

        for(int i = 0; i < n; i++)
        {
            T element = list.remove( list.size() - 1 );
            list.add(0, element);
        }
        return this;
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return "list=" + list.toString();
    }
}
