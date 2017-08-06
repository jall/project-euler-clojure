(ns q-007.core-test
  (:require [clojure.test :refer :all]
            [q-007.core :refer :all]))

(deftest q-007-test
  (is (= (-main) 104743)))
