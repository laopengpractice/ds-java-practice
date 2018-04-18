package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wenpengfei on 2018/4/10.
 */
public class ShoppingOffers_638 {

    //{2, 5} {{3, 0, 5}. {1, 2, 10}} {3, 2}
    public static int shoppingOffers(List<Integer> prices, List<List<Integer>> offers, List<Integer> needs) {
        boolean fulfill = fulfill(needs);
        if (fulfill) {
            return 0;
        }

        int min = 0;
        for (int i = 0; i < prices.size(); ++i) {
            min += prices.get(i) * needs.get(i);
        }

        for (int i = 0; i < offers.size(); ++i) {
            List<Integer> offer = offers.get(i);
            List<Integer> newNeeds = new ArrayList<>();
            for (int j = 0; j < needs.size(); ++j) {
                if (needs.get(j) < offer.get(j)) {
                    break;
                }
                newNeeds.add(needs.get(j) - offer.get(j));
            }
            if (newNeeds.size() < needs.size()) {
                continue;
            }
            int cost = shoppingOffers(prices, offers, newNeeds);
            if (cost + offer.get(offer.size() - 1) < min) {
                min = cost + offer.get(offer.size() - 1);
            }
        }

        return min;
    }

    private static boolean fulfill(List<Integer> needs) {
        for (Integer n : needs) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(new Integer[]{2, 3, 4});
        List<List<Integer>> offers = new ArrayList<>();
        offers.add(Arrays.asList(new Integer[]{1, 1, 0, 4}));
        offers.add(Arrays.asList(new Integer[]{2, 2, 1, 9}));
        List<Integer> needs = Arrays.asList(new Integer[]{1, 2, 1});
        int cost = shoppingOffers(prices, offers, needs);
        System.out.println(cost);
    }
}
