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
    (is (= false (some?' even? [1 3 5])))))

(deftest ascending?-test
  (testing "return true when coll elements are in ascending order"
    (is (= true (ascending? [1 2 3]))))
  (testing "return false when coll elements are in descending order"
    (is (= false (ascending? [1 5 3])))))

(deftest sum-of-adjacent-digits-test
  (testing "give sum of adjacent digits of a collection"
    (is (= [3 5] (sum-of-adjacent-digits [1 2 3])))))
