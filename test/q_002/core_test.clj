(ns q-002.core-test
  (:require [clojure.test :refer :all]
            [q-002.core :refer :all]))

(deftest q-002-test
  (testing "Question 2 is correct"
    (is (= (-main) 4613732))))
