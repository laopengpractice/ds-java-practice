package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/11/14.
 */
public class KthSmallestInMatrix {

    static class Pair {
        int[][] matrix;
        int i;
        int j;

        public Pair(int[][] matrix, int i, int j) {
            this.matrix = matrix;
            this.i = i;
            this.j = j;
        }

        public int val() {
            return matrix[i][j];
        }
    }

    public static int kthSmallestInMatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        Pair[] heap = new Pair[n];
        for (int i = 0; i < n; ++i) {
            heap[i] = new Pair(matrix, 0, i);
        }
        buildHeap(heap);
        for (int i = 0; i < k - 1; ++i) {
            Pair min = heap[0];
            if (min.i < m - 1) {
                Pair newPair = new Pair(matrix, min.i + 1, min.j);
                heap[0] = newPair;
                adjust(heap, n, 0);
            } else {
                n--;
                heap[0] = heap[n];
                adjust(heap, n, 0);
            }
        }

        return heap[0].val();
    }

    private static void buildHeap(Pair[] heap) {
        int n = heap.length;
        for (int i = n / 2 - 1; i >= 0; --i) {
            adjust(heap, heap.length, i);
        }
    }

    private static void adjust(Pair[] heap, int n, int k) {
        int left = (k + 1) * 2 - 1;
        while (left < n) {
            int right = left + 1;
            int min = left;
            if (right < n && heap[right].val() < heap[left].val()) {
                min = right;
            }
            if (heap[min].val() > heap[k].val()) {
                break;
            }

            swap(heap, min, k);
            k = min;
            left = 2 * k + 1;
        }
    }

    public static void swap(Pair[] heap, int i, int j) {
        Pair t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2 , 10, 14};
        matrix[1] = new int[]{3, 5, 11, 15};
        matrix[2] = new int[]{4, 6, 18, 20};

        System.out.println(kthSmallestInMatrix(matrix, 8));
    }
}
