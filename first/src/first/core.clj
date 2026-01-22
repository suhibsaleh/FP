(ns first.core
  (:require [clojure.string :as clstr])
  (:gen-class))

(defn strings []
  (def str1 "testing besting fixing")
  (println (clstr/blank? str1))

  (def strls (clstr/split str1 #" "))
  (println strls)
  (println (clstr/join " " strls))
  (println)
  )

(defn lists []
  (def allList (list 1 2 "nice" true))
  (println allList)
  (println (first allList))
  (println (rest allList))
  (println(nth allList 2))
  (println(list* "new list" allList))
  (println(list* allList "new list" ))
  (println(cons "left add" allList))
  (println)
  )

(defn sets[]
  (def allSet (set [1 1 2 2 3 'a' 'b' 'a']))
  (println allSet)
  (println (get allSet 'a'))
  (println (contains? allSet 'a'))
  (println (conj allSet 'c'))
  (println (disj allSet 'a'))
  (println)
  )

(defn vectors[]
  (def allVector (vector 1 2 3 1 "test"))
  (println allVector)
  (println (get allVector 2))
  (println (conj allVector 'c'))
  (println (pop allVector))
  (println (subvec allVector 0 3))
  (println)
  )

(defn maps[]
  (def allMaps (hash-map "name" "suhib" "age" 23))
  (println allMaps)
  (println (get allMaps "name"))
  (println (find allMaps "name"))
  (println (contains? allMaps "name"))
  (println (keys allMaps))
  (println (vals allMaps))
  (println)
  )

(defn ifExpressions[]

  (if true
    (println "yes")
    (println "no"))

  (if true
    (do
      (println "yes")
      (println "this is a true statement"))
    (do
      (println "no")
      (println "this is a false statement"))
    )

;  in REPL, we will only see "yes statement"
;  we are using values without any side effects such as (printing, writing)
;  we will get the last value
  (if true
    (do
      "yes"
      "yes statement")
    (do
      "no"
      "no statement")
    )

;  in REPL: we will see "value" if it was in the last line
;  other than that, we will only see second println and last printed line will be nil
  (when true
    (println "true, when")
    (println "another side effect true, when")
    "value"
    )

  (println (nil? nil)); true
  (println (nil? 1)); false

  (println (integer? 1)); true
  (println (integer? "1")); false

  (println (string? 1)); false
  (println (string? "1")); true
  (println (string? nil)); false

;  false or nil -> represent logical falsiness
;  other values will be considered correct
  (if "my string"
    (println "yes"); will print "yes"
    (println "no")
    )



  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (strings)
  (lists)
  (sets)
  (vectors)
  (maps)
  (ifExpressions)

  )
