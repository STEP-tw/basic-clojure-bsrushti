(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest map'-test
  (testing "identity with single coll"
    (is (= [1 2 3] (map' identity [1 2 3]))))
  (testing "inc with single coll"
    (is (= [2 3 4] (map' inc [1 2 3])))))

(deftest filter'-test
  (testing "even?"
    (is (= [2 4] (filter' even? [1 2 3 4]))))
  (testing "odd?"
    (is (= [1 3] (filter' odd? [1 2 3 4])))))


(deftest count'-test
  (testing "return length of coll as 4"
    (is (= 4 (count' [1 2 3 4])))))

(deftest every?'-test
  (testing "reverse the list"
    (is (= 4 (count' [1 2 3 4])))))
