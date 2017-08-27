(ns q-015.core-test
  (:require [clojure.test :refer :all]
            [q-015.core :refer :all]))

(deftest q-015-test
  (is (= (-main) 137846528820N)))
