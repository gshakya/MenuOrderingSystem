-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2015 at 06:03 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `menuordering`
--

-- --------------------------------------------------------

--
-- Table structure for table `dishes`
--

CREATE TABLE `dishes` (
  `dish_id` int(10) NOT NULL,
  `dish_name` varchar(40) NOT NULL,
  `current` char(1) NOT NULL DEFAULT 'Y'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dishes`
--

INSERT INTO `dishes` (`dish_id`, `dish_name`, `current`) VALUES
(1, 'Pizza', 'Y'),
(2, 'Pasta', 'Y'),
(3, 'Fried Chicken', 'Y'),
(4, 'Macaroni and Cheese', 'Y'),
(5, 'Chocolate-chip Cookies', 'Y'),
(6, 'Hot Dogs', 'Y'),
(7, 'Russian Salad', 'Y'),
(8, 'Rice Pudding', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL DEFAULT '-1',
  `current` char(1) NOT NULL DEFAULT 'Y'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `dish_id`, `User_id`, `current`) VALUES
(65, 2, 17, 'N'),
(66, 3, 17, 'N'),
(67, 4, 17, 'N'),
(68, 2, 16, 'N'),
(69, 3, 16, 'N'),
(70, 4, 16, 'N'),
(71, 5, 16, 'N'),
(72, 1, 18, 'Y'),
(73, 3, 18, 'Y'),
(74, 4, 18, 'Y'),
(75, 5, 18, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user_name`, `first_name`, `last_name`, `password`, `is_admin`) VALUES
(10, 'gshakya', 'Gunjan', 'Shakya', 'asdf', 1),
(11, 'ppoudel', 'Prabhat', 'Poudel', 'asdf', 0),
(14, 'msiwakoti', 'Madan', 'Siwakoti', 'asdf', 0),
(15, 'gbasnet', 'Govinda', 'Basnet', 'asdf', 0),
(16, 'nlimbu', 'Nagendra', 'Limbu', 'zxc', 0),
(17, 'sbhusal', 'Samrat', 'Bhusal', '123', 0),
(18, 'bsharma', 'Bimal', 'Sharma', '123', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dishes`
--
ALTER TABLE `dishes`
  ADD PRIMARY KEY (`dish_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `ordered_by` (`User_id`),
  ADD KEY `menu_id` (`dish_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `user_id` (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dishes`
--
ALTER TABLE `dishes`
  MODIFY `dish_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
