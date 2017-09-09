(ns q-026.core-test
  (:require [clojure.test :refer :all]
            [q-026.core :refer :all]))

(deftest q-026-test
  (is (= (-main) 983)))
