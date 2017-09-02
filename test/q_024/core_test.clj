(ns q-024.core-test
  (:require [clojure.test :refer :all]
            [q-024.core :refer :all]))

(deftest q-024-test
  (is (= (-main) "2783915604")))
