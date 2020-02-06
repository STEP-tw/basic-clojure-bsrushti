(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest map'-test
  (testing "with single coll"
    (testing "identity"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "inc"
      (is (= [2 3 4] (map' inc [1 2 3])))))

  (testing "with two coll"
    (testing "+ with same number of element in both coll"
      (is (= [2 4 6] (map' + [1 2 3] [1 2 3]))))
    (testing "+ with different number of element in both coll"
      (is (= [2 4] (map' + [1 2 3] [1 2]))))))

(deftest filter'-test
  (testing "even?"
    (is (= [2 4] (filter' even? [1 2 3 4]))))
  (testing "odd?"
    (is (= [1 3] (filter' odd? [1 2 3 4])))))


(deftest count'-test
  (testing "return length of coll as 4"
    (is (= 4 (count' [1 2 3 4])))))

(deftest reverse'-test
  (testing "reverse the list"
    (is (= [4 3 2 1] (reverse' [1 2 3 4])))))

(deftest every?'-test
  (testing "return true for even coll"
    (is (= true (every?' even? [2 4]))))
  (testing "return false for non-even coll"
    (is (= false (every?' even? [1 2 4])))))

(deftest some?'-test
  (testing "return true when coll contains even element"
    (is (= true (some?' even? [2 1 4]))))
  (testing "return when coll do not contains even element"
    (is (= false (some?' even? [1 3 5]))))
  (testing "return when coll do not contains even element"
    (is (= false (some?' even? [])))))

(deftest ascending?-test
  (testing "return true when coll elements are in ascending order"
    (is (= true (ascending? [1 2 3]))))
  (testing "return false when coll elements are in descending order"
    (is (= false (ascending? [1 5 3])))))

(deftest sum-of-adjacent-digits-test
  (testing "give sum of adjacent digits of a collection"
    (is (= [3 5] (sum-of-adjacent-digits [1 2 3]))))
  (testing "collection with single digit"
    (is (= [] (sum-of-adjacent-digits [1])))))

(deftest difference-test
  (testing "difference of two set"
    (is (= '(4 5) (difference [1 2 3] [1 2 3 4 5]))))
  (testing "empty set"
    (is (= '() (difference [1 2 3] [])))))

(deftest union-test
  (testing "union of two set"
    (is (= '(1 2 3 4 5 6) (union [1 2 3] [4 5 6]))))
  (testing "union of two same set"
    (is (= '(1 2 3 1 2 3) (union [1 2 3] [1 2 3])))))

(deftest dedupe'-test
  (testing "adjacent duplicate elements"
    (is (= '(1 2 3 0) (dedupe' [1 1 2 3 3 0]))))
  (testing "non-adjacent duplicate elements"
    (is (= '(1 2 3 0 2) (dedupe' [1 1 2 3 3 0 2])))))

(deftest reduce'-test
  (testing "without accumulator"
    (testing "return sum of elements"
      (is (= 6 (reduce' + [1 2 3]))))
    (testing "return subtraction of elements"
      (is (= -4 (reduce' - [1 2 3])))))

  (testing "with accumulator"
    (testing "return mul of elements"
      (is (= 0 (reduce' * 0 [1 2 3]))))
    (testing "return subtraction of elements"
      (is (= -1 (reduce' - 5 [1 2 3]))))))

(deftest cross-product-test
  (testing "return cross-product"
    (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]]
           (cross-product [1 2 3] [4 3 5])))))

(deftest double-up-test
  (testing "repeating each element of coll twice"
    (is (= '(1 1 2 2 3 3) (double-up [1 2 3])))))

(deftest sqr-of-the-first-test
  (testing "return same number of square of first element"
    (is (= [4 4 4] (sqr-of-the-first [2 3 4])))))

(deftest split-comb-test
  (testing "even number coll"
    (is (= [1 3 2 4] (split-comb [1 2 3 4]))))
  (testing "odd number coll"
    (is (= [1 3 2 4 5] (split-comb [1 2 3 4 5])))))

(deftest muted-thirds-test
  (testing "make every third element to 0"
    (is (= [1 2 0 4 15 0 7] (muted-thirds [1 2 8 4 15 2 7])))))

(deftest third-or-fifth-test
  (testing "return third or fifth element"
    (is (= [1 4 0 7] (third-or-fifth [1 2 0 4 15 0 7])))))

(deftest distinct'-test
  (testing "return distinct element"
    (is (= [1 4 6 3 2] (distinct' [1 4 2 3 2 6])))))

(deftest index-of-test
  (testing "return index of given element"
    (is (= 2 (index-of [1 2 3 4 5] 3))))
  (testing "return -1 when element not found"
    (is (= -1 (index-of [1 2 3 4 5] 300)))))

(deftest palindrome?-test
  (testing "pallindrome collection"
    (is (= true (palindrome? [1 2 3 2 1]))))
  (testing "not a pallindrome collection"
    (is (= false (palindrome? [1 2 2 3 1])))))
