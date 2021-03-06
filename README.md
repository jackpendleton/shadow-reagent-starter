# my-shadow-reagent

Minimalist starter for fullstack Clojure/ClojureScript web apps:

* ring/compojure backend
* reagent/shadow-cljs frontend
* statically-served entry point
* js/css hot-reloading
* clj/cljs repls

## Getting started

Install `npm` dependencies and compile Javascript:

```
$ npm run init
```

Start the REPL:

```
$ lein repl
```

Start the server on http://localhost:3000:

```clojure
(start-server)
```

Start `shadow-cljs`:

```
$ shadow-cljs watch app
```

The dev-server will be available on http://localhost:3333.


## Notes

Based on a modified Leiningen [`shadow-cljs`](https://github.com/thheller/shadow-cljs) 
[`reagent-template`](https://github.com/reagent-project/reagent-template) and inspired by 
[`fullstack-clojure`](https://github.com/tamizhvendan/fullstack-clojure).

The [`rest`](https://github.com/jackpendleton/shadow-reagent-starter/tree/rest) branch contains a basic REST API implementation inspired by [Functional Human](https://link.medium.com/6RGFysAbB2).