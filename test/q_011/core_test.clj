(ns q-011.core-test
  (:require [clojure.test :refer :all]
            [q-011.core :refer :all]))

(deftest q-011-test
  (is (= (-main) 70600674)))
