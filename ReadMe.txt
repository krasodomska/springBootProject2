Zadanie podstawowe: Napisz REST API dla listy pojazdów. Pojazd będzie miał pola: id, mark, model, color. API które będzie obsługiwało metody webowe:

    do pobierania wszystkich pozycji
    do pobierania elementu po jego id
    do pobierania elementów w określonym kolorze (query)
    do dodawania pozycji
    do modyfikowania pozycji
    do modyfikowania jednego z pól pozycji
    do usuwania jeden pozycji

Przy starcie aplikacji mają dodawać się 3 pozycje.

Dla ambitnych:

    rozbuduj aplikacje o możliwość zwracania danych w postaci XML
    dodaj obsługę Swgger UI - swagger użyty dzięki OpenAPI 3.0 (nie jest konieczne dodawanie dodatkowego kodu) dostępne http://localhost:8080/swagger-ui/index.html#/car-api
    zaimplementuj HATEOAS
