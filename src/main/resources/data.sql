INSERT INTO user_details(id, birth_date,name)
VALUES
(10001, '1998-10-10', 'Ramesh'),
(10002, '1999-10-10', 'Suresh'),
(10003, '2000-10-10', 'Rajesh'),
(10004, '2001-10-10', 'Dinesh');

INSERT INTO post(id, description, user_id)
VALUES
(20001, 'I want to learn AWS', 10001),
(20002, 'I want to learn DevOps', 10001),
(20003, 'I like GCP instead of AWS', 10002),
(20004, 'I need AWS certifications', 10003);