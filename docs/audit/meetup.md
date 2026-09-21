# Технический аудит: Meetup

## 1. Название ресурса / компании
Meetup — платформа для организации встреч по интересам. Владелец — Bending Spoons.

## 2. Адрес ресурса
https://www.meetup.com

## 3. Анализ архитектуры и логики

**Условия проверки:** Wi-Fi, дом, Chrome, 22.09.2026.

- **Тип приложения:** Next.js (SSR + гидратация).
- **API:** GraphQL. Актуальный URL: `https://api.meetup.com/gql-ext`.
- **Аутентификация:** OAuth 2.0. Rate limit: 500 запросов за 60 секунд.
- **CDN:** Fastly.
- **Хостинг:** AWS (Amazon Route 53).

## 4. Семантические элементы HTML5

| Элемент      | Количество |
|--------------|------------|
| `<header>`   | 1          |
| `<nav>`      | 3          |
| `<main>`     | 1          |
| `<section>`  | 8          |
| `<article>`  | 3          |
| `<time>`     | 12         |
| `<footer>`   | 1          |

**Вывод:** самая семантичная разметка среди трёх конкурентов —
используются `<article>` для карточек событий и `<time>` (12 раз)
для дат проведения.

## 5. Семантические классы

- `.eventCard`
- `.groupCard__title`
- `.searchFilters__container`

## 6. Адаптивность

Media-запросы: `1024px`, `768px`, `480px`.

## 7. Lighthouse

**Условия:** Wi-Fi, дом, Chrome, режим инкогнито, 22.09.2026.

| Категория       | Desktop | Mobile |
|-----------------|---------|--------|
| Performance     | 68      | 44     |
| Accessibility   | 92      | 88     |
| Best Practices  | 69      | 69     |
| SEO             | 92      | 92     |

**Проблемы:** Performance на Mobile 44 — тяжёлые JavaScript-бандлы
(GraphQL-клиент + трекинг), высокий TBT. Accessibility 88 на мобильном —
некоторые элементы без alt-атрибутов.

## 8. Локальное хранилище и cookies

- **localStorage:** `meetup.lastSearch`, `meetup.theme`, `meetup.notificationPrefs`
- **Cookies:** `MEETUP_SESSION`, `_ga`, `_fbp`

## 9. Маркетинговые инструменты и аналитика

- Google Tag Manager
- Meta Pixel (Facebook Pixel) v2.9.261
- Google Analytics 4 (через GTM)
