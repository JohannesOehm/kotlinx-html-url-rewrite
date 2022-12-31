# kotlinx-html-url-rewrite
Adds a GET/POST parameter to all URLs, which are created with the [kotlinx.html DSL](https://github.com/Kotlin/kotlinx.html).

Current rewriting rules: 
* Add query parameter to `a[href]`
* Add query parameter to `form[action]` url if `form[method="GET"]`
* Add a `input[type="hidden"]` if `form[method="POST"]`

e.g.

```kotlin
fun main() {
    println(buildString {
        appendHTML().urlRewrite("{year:2021}").html {
            head { }
            body {
                a(href = "bar") {
                    +"I'm a link to a different page"
                }
            }
        }
    })
}
```
will result in 
```html
<html>
  <head></head>
  <body><a href="bar?q={year:2021}">I'm a link to a different page</a></body>
</html>
```

This way, you can store non-sensitive session data (like language settings, sorting/filter parameters) in the client
without the need to use cookies and therefore no need to annoy the user with EU cookie banners.

This can be useful if you have your entire page rendered server-side using the Ktor server framework for example.

You might want to encrypt the data with a server secret depending on its sensitivity.   


**Just a proof of concept. Do not use in production!**

Current limitation:
* Parameters are added to any url, so data might get leaked to external URLs.