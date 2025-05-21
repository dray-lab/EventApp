-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 05:59 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `event_name` varchar(200) NOT NULL,
  `event_type` varchar(100) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `u_id`, `user_name`, `event_name`, `event_type`, `amount`, `created_at`, `updated_at`) VALUES
(1, 1, 'johndoe', 'John & Jane Wedding', 'Ocassions', 50000.00, '2025-05-21 10:34:35', '2025-05-21 10:34:35');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `event_type` varchar(100) NOT NULL,
  `event_name` varchar(200) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `venue` varchar(255) NOT NULL,
  `packages` text DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `u_id`, `event_type`, `event_name`, `amount`, `venue`, `packages`, `created_at`, `updated_at`) VALUES
(1, 1, 'Wedding', 'John & Jane Wedding', 50000.00, 'Seaside Garden Resort', 'Gold Package', '2025-05-21 10:24:41', '2025-05-21 10:24:41'),
(22, 1, 'Ocassions', 'John & Jane Wedding', 50000.00, 'Seaside Garden Resort', 'Gold Package', '2025-05-21 10:27:46', '2025-05-21 11:47:01'),
(24, 1, 'Corporate', 'Tech Innovators Forum', 60000.00, 'Metro Convention Center', 'Corporate Package', '2025-05-21 10:27:46', '2025-05-21 10:27:46'),
(25, 3, 'Concert', 'Rock & Roll Night', 85000.00, 'Open Grounds Arena', 'Platinum Package', '2025-05-21 10:27:46', '2025-05-21 10:27:46'),
(26, 2, 'Anniversary', '25th Anniversary of Mr. & Mrs. Smith', 30000.00, 'Rosewood Garden', 'Classic Package', '2025-05-21 10:27:46', '2025-05-21 10:27:46'),
(27, 2, 'Annulment', 'Freedom Ceremony for Anna & Mark', 20000.00, 'Quiet Garden Court', 'Simple Package', '2025-05-21 10:27:46', '2025-05-21 10:27:46'),
(30, 1, 'Entertainment', 'Comedy', 12000.00, 'Cebu', 'Gold Packages', '2025-05-21 11:10:06', '2025-05-21 11:10:06');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `actions` varchar(100) NOT NULL,
  `details` text DEFAULT NULL,
  `timestamp` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `actions`, `details`, `timestamp`) VALUES
(1, 10, 'Login', 'User logged in successfully', '2025-05-20 10:47:41'),
(2, 10, 'Password Change', 'Password changed successfully', '2025-05-20 11:08:23'),
(3, 10, 'Login', 'User logged in successfully', '2025-05-20 11:08:44'),
(4, 3, 'Password Change', 'Password changed successfully', '2025-05-20 11:13:06'),
(5, 3, 'Login', 'User logged in successfully', '2025-05-20 11:13:27'),
(6, 3, 'Password Change', 'Password changed successfully', '2025-05-21 09:59:09'),
(7, 3, 'Login', 'User logged in successfully', '2025-05-21 09:59:28'),
(8, 10, 'Password Change', 'Password changed successfully', '2025-05-21 10:29:38'),
(9, 10, 'Login', 'User logged in successfully', '2025-05-21 10:29:52'),
(10, 10, 'Login', 'User logged in successfully', '2025-05-21 10:34:21'),
(11, 3, 'Login', 'User logged in successfully', '2025-05-21 10:34:50'),
(12, 3, 'Login', 'User logged in successfully', '2025-05-21 10:37:57'),
(13, 3, 'Login', 'User logged in successfully', '2025-05-21 10:46:18'),
(14, 3, 'Login', 'User logged in successfully', '2025-05-21 10:49:01'),
(15, 3, 'Login', 'User logged in successfully', '2025-05-21 10:52:53'),
(16, 3, 'Login', 'User logged in successfully', '2025-05-21 10:57:41'),
(17, 3, 'Login', 'User logged in successfully', '2025-05-21 11:03:43'),
(18, 3, 'Login', 'User logged in successfully', '2025-05-21 11:09:40'),
(19, 3, 'Login', 'User logged in successfully', '2025-05-21 11:11:56'),
(20, 3, 'Login', 'User logged in successfully', '2025-05-21 11:18:07'),
(21, 3, 'Login', 'User logged in successfully', '2025-05-21 11:21:01'),
(22, 3, 'Login', 'User logged in successfully', '2025-05-21 11:26:11'),
(23, 3, 'Login', 'User logged in successfully', '2025-05-21 11:29:15'),
(24, 3, 'Login', 'User logged in successfully', '2025-05-21 11:32:33'),
(25, 3, 'Login', 'User logged in successfully', '2025-05-21 11:37:00'),
(26, 3, 'Login', 'User logged in successfully', '2025-05-21 11:38:31'),
(27, 3, 'Login', 'User logged in successfully', '2025-05-21 11:39:43'),
(28, 3, 'Login', 'User logged in successfully', '2025-05-21 11:45:51'),
(29, 10, 'Login', 'User logged in successfully', '2025-05-21 11:46:30'),
(30, 3, 'Login', 'User logged in successfully', '2025-05-21 11:52:07'),
(31, 3, 'Login', 'User logged in successfully', '2025-05-21 11:54:56'),
(32, 3, 'Login', 'User logged in successfully', '2025-05-21 11:55:55'),
(33, 3, 'Login', 'User logged in successfully', '2025-05-21 11:56:29');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_registeruser`
--

CREATE TABLE `tbl_registeruser` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(100) NOT NULL,
  `u_lname` varchar(100) NOT NULL,
  `u_email` varchar(150) NOT NULL,
  `u_username` varchar(100) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_type` enum('Admin','User') NOT NULL,
  `u_status` enum('Pending','Active','Inactive') DEFAULT 'Pending',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_registeruser`
--

INSERT INTO `tbl_registeruser` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `created_at`, `updated_at`) VALUES
(1, 'Mike', 'Bus', 'mike3@gmail.com', 'busta', 'N6CjSaZSWDeo3TPmC9HUnJog8Vg7SxGVGtuJzpkEpnA=', 'Admin', 'Active', '2025-03-18 15:41:03', '2025-03-22 15:37:30'),
(2, 'Diovely', 'Campo', 'diovely@gmail.com', 'dyubli', 'N6CjSaZSWDeo3TPmC9HUnJog8Vg7SxGVGtuJzpkEpnA=', 'User', 'Active', '2025-03-22 15:24:08', '2025-03-22 15:37:30'),
(3, 'Dray', 'Misa', 'misadranreb4@gmail.com', 'Dray', '$2a$10$QT4YMi5NFWLfGv9A6UAmluar7549gcY5DW42c05yYuuOFIiU69KQi', 'Admin', 'Active', '2025-05-05 02:22:58', '2025-05-21 01:59:09'),
(4, 'Kris Jaylon', 'Mantillas', 'jaylon@gmail.com', 'jaylon', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'User', 'Active', '2025-05-06 09:29:08', '2025-05-06 09:29:45'),
(7, 'Dranreb', 'Misa', 'misadray1@gmail.com', 'Dranreb', '0tLCWgtLLuIq00rr/ysNBLzxA+HvbcVCScJVjXwFKfE=', 'User', 'Active', '2025-05-18 08:26:23', '2025-05-20 15:30:06'),
(9, 'Draniel', 'Misa', 'misadran@gmail.com', 'Draniel', 'ovwnnU15vOKI/E5ty+0U8/2rJXxg1HsKdD+OBs4Fcqs=', 'Admin', 'Active', '2025-05-18 13:08:08', '2025-05-20 16:09:29'),
(10, 'Lance', 'Alberto', 'misadray3@gmail.com', 'Lance', '$2a$10$YYmhZ9.mR6XgrOS7exhXE.6Y5zVV46bb8rbqwC/W1l15dwQov.L.G', 'User', 'Active', '2025-05-20 15:30:44', '2025-05-21 02:29:38'),
(11, 'Jane', 'Smith', 'jane@example.com', 'janesmith', 'password456', '', 'Active', '2025-05-21 02:24:04', '2025-05-21 02:24:04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_email` (`u_email`),
  ADD UNIQUE KEY `u_username` (`u_username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `events_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_registeruser` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
