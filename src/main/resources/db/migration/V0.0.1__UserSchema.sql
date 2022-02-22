CREATE TABLE `following` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `user_id` int NOT NULL,
                             `following_id` int NOT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `Unique_Combo` (`user_id`,`following_id`),
                             KEY `FK_followed_user_idx` (`following_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

CREATE TABLE `sessions` (
                            `session_id` int NOT NULL,
                            `session_type` varchar(45) COLLATE utf8mb4_bin NOT NULL,
                            PRIMARY KEY (`session_id`),
                            UNIQUE KEY `id_UNIQUE` (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

CREATE TABLE `user_roles` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `user_id` int NOT NULL,
                              `user_role` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FK_user_userRole_idx` (`user_id`),
                              CONSTRAINT `FK_user_userRole` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) COLLATE utf8mb4_bin NOT NULL,
                         `email` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                         `password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                         `confirm_password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
                         `first_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                         `last_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                         `gender` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                         `skills_practicing` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
                         `profile_icon` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
                         `DOB` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `username_UNIQUE` (`username`),
                         UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin

CREATE TABLE `user_sessions` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `user_id` int NOT NULL,
                                 `session_id` int DEFAULT NULL,
                                 `date` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
                                 `rating` int DEFAULT NULL,
                                 `session_name` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
                                 `notes` varchar(5000) COLLATE utf8mb4_bin DEFAULT NULL,
                                 `time` int DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `user_id_idx` (`user_id`),
                                 KEY `FK_userSession_session_idx` (`session_id`),
                                 CONSTRAINT `FK_userSession_session` FOREIGN KEY (`session_id`) REFERENCES `sessions` (`session_id`),
                                 CONSTRAINT `FK_userSession_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin