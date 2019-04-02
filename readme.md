# Spring Batch example, transform data from MySql to MongoDB.

### Setup
```bash
$: docker-compose run --rm --service-ports contacts-mongo-setup
$: docker-compose run --rm --service-ports contacts-mysql-setup
```
Just do this once.

### Running
```bash
$: docker-compose run --rm --service-ports app
```