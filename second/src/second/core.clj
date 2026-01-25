(ns second.core
  (:gen-class))

(defn my-let[]
  (println (let [x 2] x))

  (def y 2)
  (println (let [y (inc y)] y))

  (def my-list [1 2 3 4 5]) (println (let [[f & r] my-list] (list* f r)))

  )

(defn my-rec-rec[]
  (loop [total 0,current-list [1 2 3 4 5]]
    (if (empty? current-list)
      total
      (recur(+ total (first current-list)) (rest current-list))
      )
    )
  )

(defn my-reg-reg[]
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  ;  #"hello"           ; Matches "hello"             ;
  ;  #"\d+"            ; Matches one or more digits   ;
  ;  #"[A-Za-z]+"      ; Matches one or more letters  ;
  ;  #"\w{3,10}"       ; Matches 3-10 word characters ;
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  (def str-to-match "this is very important string")
  (println (re-matches #"this" str-to-match)); nil (should full match)
  (println (re-matches #"this is very important string" str-to-match)); works fine (will print the full string)
  )

(defn sum-to-x [x]
  (loop [total 0, current x]
    (if (< current 1)
        total
      (recur (+ total current) (dec current))
      )
    )
  )

(defn mapset [ls]
  (loop [total #{}, current-ls ls]
    (if (empty? current-ls)
      total
      (recur (into total (first current-ls)) (rest current-ls))
      )
    )
  )

(defn -main
  [& args]

  (println (mapset [1 2 3 3 2 1 2 3 4]))
  )
