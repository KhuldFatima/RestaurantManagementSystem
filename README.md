# Zauq Restaurant Management System

A Java Spring Boot backend for managing restaurant operations like orders, tables, menu, customers, and daily sales. Paired with a vanilla JS frontend POS interface.

## Stack

- **Backend:** Java 21, Spring Boot 3.2, JDBC (no ORM), MySQL
- **Frontend:** HTML + Vanilla JS
- **Build:** Maven, deployed via embedded Tomcat

## Features

- Order processing with 16% GST and discount logic (10% Askari/Meezan cards, 5% first Wednesday of month)
- Table status management (Available / Occupied / Reserved)
- Customer registration with duplicate phone check
- Role-based login (Admin, Waiter, Cashier, Manager)
- Daily sales report (gross revenue, net revenue, discounts, tax)
