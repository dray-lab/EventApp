-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2025 at 06:06 AM
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
  `event_name` text NOT NULL,
  `event_type` text NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`id`, `event_name`, `event_type`, `amount`, `created_at`) VALUES
(1, 'Jazz Night', 'Concert', 45.00, '2025-05-06 07:47:43');

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `event_type` varchar(50) DEFAULT NULL,
  `event_name` varchar(100) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `venue` varchar(100) DEFAULT NULL,
  `packages` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `event_type`, `event_name`, `amount`, `venue`, `packages`) VALUES
(1, 'Occasion', 'Birthday Party - Bronze', 15000.00, 'TBD', 'Up to 50 Attendees\r\nCatering Services\r\nCake\r\n'),
(2, 'Occasion', 'Birthday Party - Silver', 22000.00, 'Drayenz Hall', 'Full styling, Host, Sound system, Cake, Catering for 50, Photographer'),
(3, 'Ocassions', 'Birthday Party - Gold', 45000.00, 'Drayenz Hall', 'Full styling, Sound system, Cake, Catering for 75, Host, Photographer + Videographer'),
(4, 'Ocassions', 'Birthday Party - Premium', 100000.00, 'Drayenz Grand Venue', 'Full concept styling, LED stage, Video team, Photo booth, Catering 150 pax, Entertainment'),
(5, 'Occasion', 'Wedding Package', 70000.00, 'Grand Hotel Garden', 'Event coordination, Catering, Music, Decor, Host, Photography'),
(6, 'Occasion', 'Reunion Package', 50000.00, 'City Convention Hall', 'Event coordination, Catering, Sound System, Host, Games'),
(7, 'Entertainment', 'BINI Concert', 11000.00, 'MOA Arena', 'VIP Standing, Patron, Box A/B, Gen Ad - Seat Map'),
(8, 'Entertainment', 'BTS', 9500.00, 'MOA Arena', 'VIP Standing, Patron, Box A/B, Gen Ad - Seat Map'),
(9, 'Entertainment', 'Theater Show', 6000.00, 'Cultural Center', 'Main Stage Seating, Balcony, VIP Access'),
(10, 'Entertainment', 'Comedy Show', 3000.00, 'Live Club', 'Front Row, Regular Seat, Drinks and Snacks');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `actions` varchar(255) NOT NULL,
  `details` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `actions`, `details`, `timestamp`) VALUES
(1, 1, 'Create Event', 'Created a new event called Summer Beach Volleyball 2025.', '2025-05-05 02:57:41'),
(2, 2, 'Update Event', 'Updated the event details for Volleyball Tournament 2025.', '2025-05-05 02:57:41'),
(3, 1, 'Delete Event', 'Deleted event \"Beach Volleyball Showdown\".', '2025-05-05 02:57:41'),
(4, 3, 'Login', 'User logged in successfully', '2025-05-05 02:58:02'),
(5, 3, 'Login', 'User logged in successfully', '2025-05-05 03:02:18'),
(6, 3, 'Login', 'User logged in successfully', '2025-05-05 03:04:40'),
(7, 3, 'Login', 'User logged in successfully', '2025-05-05 03:51:46'),
(8, 3, 'Login', 'User logged in successfully', '2025-05-05 03:52:58'),
(9, 3, 'Login', 'User logged in successfully', '2025-05-05 03:55:35'),
(10, 3, 'Login', 'User logged in successfully', '2025-05-05 03:58:59'),
(11, 3, 'Login', 'User logged in successfully', '2025-05-05 04:01:23'),
(12, 3, 'Login', 'User logged in successfully', '2025-05-06 08:58:40'),
(13, 3, 'Login', 'User logged in successfully', '2025-05-06 09:00:21'),
(14, 3, 'Login', 'User logged in successfully', '2025-05-06 09:16:29'),
(15, 3, 'Login', 'User logged in successfully', '2025-05-06 09:18:12'),
(16, 3, 'Login', 'User logged in successfully', '2025-05-06 09:23:12'),
(17, 4, 'Login', 'User logged in successfully', '2025-05-06 09:29:49'),
(18, 4, 'Password Reset Request', 'User requested a password reset', '2025-05-06 09:34:33'),
(19, 4, 'Login', 'User logged in successfully', '2025-05-06 09:36:23'),
(20, 4, 'Login', 'User logged in successfully', '2025-05-06 09:42:41'),
(21, 4, 'Login', 'User logged in successfully', '2025-05-06 09:47:30'),
(22, 4, 'Login', 'User logged in successfully', '2025-05-06 09:57:00'),
(23, 4, 'Login', 'User logged in successfully', '2025-05-06 10:02:32'),
(24, 4, 'Login', 'User logged in successfully', '2025-05-06 10:04:36'),
(25, 4, 'Login', 'User logged in successfully', '2025-05-06 10:08:15'),
(26, 4, 'Login', 'User logged in successfully', '2025-05-06 10:10:11'),
(27, 4, 'Login', 'User logged in successfully', '2025-05-06 11:40:57'),
(28, 4, 'Login', 'User logged in successfully', '2025-05-06 11:41:44'),
(29, 4, 'Login', 'User logged in successfully', '2025-05-06 11:42:47'),
(30, 4, 'Login', 'User logged in successfully', '2025-05-06 11:45:21'),
(31, 4, 'Login', 'User logged in successfully', '2025-05-06 12:00:26'),
(32, 4, 'Login', 'User logged in successfully', '2025-05-06 12:15:39'),
(33, 4, 'Login', 'User logged in successfully', '2025-05-06 12:17:50'),
(34, 3, 'Login', 'User logged in successfully', '2025-05-06 14:36:32');

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `password_resets`
--

INSERT INTO `password_resets` (`id`, `email`, `token`, `created_at`) VALUES
(1, 'jaylon@gmail.com', 'mPyBJsgXM8', '2025-05-06 09:34:33');

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
(3, 'Jay', 'Cabatuan', 'jay@gmail.con', 'jay', '+DWqqT508rt0Z92IyfDnOW4nJzG53cNQ7N50xGNLNPM=', 'Admin', 'Active', '2025-05-05 02:22:58', '2025-05-05 02:23:39'),
(4, 'Kris Jaylon', 'Mantillas', 'jaylon@gmail.com', 'jaylon', 'x3Xnt1ft5jDNCqERO9ECZhqziCnKUqZCKreChi8mhkY=', 'User', 'Active', '2025-05-06 09:29:08', '2025-05-06 09:29:45');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `password_resets`
--
ALTER TABLE `password_resets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_registeruser`
--
ALTER TABLE `tbl_registeruser`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
