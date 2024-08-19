CREATE TABLE IF NOT EXISTS Subscription
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    type           VARCHAR(50) NOT NULL,
    window_in_secs INT         NOT NULL,
    throttle       INT         NOT NULL
);

CREATE TABLE IF NOT EXISTS UserRequest
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id      VARCHAR(250) NOT NULL,
    request_time DATETIME     NOT NULL
);

CREATE TABLE IF NOT EXISTS UserSubscription
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id         VARCHAR(250) NOT NULL,
    subscription_id INT          NOT NULL
);

INSERT INTO Subscription (id, type, window_in_secs, throttle)
VALUES (1, 'BASIC', 60, 10);
INSERT INTO Subscription (id, type, window_in_secs, throttle)
VALUES (2, 'PREMIUM', 60, 200);
INSERT INTO Subscription (id, type, window_in_secs, throttle)
VALUES (3, 'ENTERPRISE', 60, 500);