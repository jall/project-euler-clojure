(ns q-020.core-test
  (:require [clojure.test :refer :all]
            [q-020.core :refer :all]))

(deftest q-020-test
  (is (= (-main) 648)))
