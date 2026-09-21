# Технический аудит: Eventbrite

## 1. Название ресурса / компании
Eventbrite, Inc. — американская платформа для создания мероприятий и продажи билетов.

## 2. Адрес ресурса
https://www.eventbrite.com

## 3. Анализ архитектуры и логики

**Условия проверки:** Wi-Fi, дом, Chrome, 22.09.2026.

- **Тип приложения:** SPA на Next.js (React).
- **API:** REST, база `https://www.eventbriteapi.com/v3`. Примеры эндпоинтов:
  - `GET /events/{id}/` — детали события
  - `GET /events/{id}/ticket_classes/` — типы билетов
  - `POST /events/{id}/publish/` — публикация
  - `POST /events/{id}/cancel/` — отмена
- **Аутентификация:** OAuth 2.0 Bearer token.
- **Хостинг:** AWS (Amazon Route 53, CloudFront).
- **CDN:** Amazon CloudFront.
- **Веб-сервер:** nginx.

## 4. Семантические элементы HTML5

| Элемент      | Количество |
|--------------|------------|
| `<header>`   | 1          |
| `<nav>`      | 2          |
| `<main>`     | 1          |
| `<section>`  | 5          |
| `<article>`  | 0          |
| `<time>`     | 0          |
| `<footer>`   | 1          |

**Вывод:** используется базовая семантика HTML5 (`<header>`, `<nav>`,
`<main>`, `<footer>`), однако карточки событий построены на `<div>`,
а не на `<article>`, и не используется `<time>` для дат.

## 5. Семантические классы (при div-вёрстке)

- `.event-card__container`
- `.search-bar__input`
- `.organizer-dashboard__stats`

## 6. Адаптивность

Media-запросы: `1200px`, `992px`, `768px`, `480px`. Mobile-first.

## 7. Lighthouse

**Условия:** Wi-Fi, дом, Chrome, режим инкогнито, 22.09.2026.

| Категория       | Desktop | Mobile |
|-----------------|---------|--------|
| Performance     | 90      | 42     |
| Accessibility   | 95      | 95     |
| Best Practices  | 69      | 69     |
| SEO             | 100     | 100    |

**Проблемы:** значительное падение Performance на мобильной версии
(42 против 90 на Desktop) — большие неоптимизированные изображения,
блокирующие рендер скрипты. Best Practices 69 — вероятно, устаревшие
библиотеки или небезопасные запросы.

## 8. Локальное хранилище и cookies

- **localStorage:** `eblang`, `ajs%3Acookies`, `ajs%3Atest`
- **Cookies:** `SP SS AS _cfuvid __cf_bm`, `stableId`, `G`, `eblang`, `_s`, `brwsr`

## 9. Маркетинговые инструменты и аналитика

- Google Tag Manager
- Google Analytics 4
- Meta Pixel (Facebook SDK)
- AB Tasty
- Amplitude
