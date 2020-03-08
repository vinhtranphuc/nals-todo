INSERT IGNORE INTO `hibernate_sequence` (`next_val`) VALUES
	(11),
	(1);
INSERT IGNORE INTO `roles` (`role_id`, `name`) VALUES
	(2, 'ROLE_ADMIN'),
	(1, 'ROLE_USER');
INSERT IGNORE INTO `users` (`user_id`, `created_at`, `updated_at`, `email`, `name`, `password`, `username`) VALUES
	(1, '2020-03-08 10:03:00', '2020-03-08 10:03:00', 'vinhtranphuc@gmail.com', 'Tran Phuc Vinh', '$2a$10$5ERgZqDh0NwGqVA2qbwE0.oRfkSRrS.v.TkfIXaNP2Z6W16YYcvSa', 'admin'),
	(2, '2020-03-08 10:03:33', '2020-03-08 10:03:35', 'xxx@xxx.com', 'XXX', '$2a$10$5ERgZqDh0NwGqVA2qbwE0.oRfkSRrS.v.TkfIXaNP2Z6W16YYcvSa', 'XXX');
INSERT IGNORE INTO `user_roles` (`user_id`, `role_id`) VALUES
	(2, 1),
	(1, 2);
INSERT IGNORE INTO `works` (`work_id`, `description`, `end_date`, `start_date`, `work_name`, `user_id`, `created_at`, `updated_at`, `create_by`, `updated_by`) VALUES
	(2, 'Work 2 edited', '2020-04-20 10:01:32', '2020-02-08 10:01:32', 'Work 2 edited', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 1, 1),
	(3, 'xzsdsadasd', '2020-02-15 10:05:04', '2020-03-08 10:05:08', 'Work 3', 2, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1),
	(6, 'description', '2020-04-20 10:01:32', '2020-04-08 10:01:32', 'Work 3', 1, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 1, 1);