package edu.estu;

/**
 * Interface for Knapsack Solution
 */
public interface IKS {

    long totalValue();

    long totalWeight();

    int numItems();

    long capacity();

    String name();

    String tag();


    default String ToString() {
        return name() + "[" +
                ", numItems=" + numItems() +
                ", totalWeight=" + totalWeight() +
                ", totalValue=" + totalValue() +
                ", occupancyRate=" + String.format("%.1f", 100D * totalWeight() / capacity()) + "%" +
                ']';
    }
}
