USE [master]
GO
/****** Object:  Database [mineria_foretell]    Script Date: 18-01-2016 19:07:32 ******/
CREATE DATABASE [mineria_foretell]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'mineria_foretell', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\mineria_foretell.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'mineria_foretell_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\mineria_foretell_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [mineria_foretell] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [mineria_foretell].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [mineria_foretell] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [mineria_foretell] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [mineria_foretell] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [mineria_foretell] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [mineria_foretell] SET ARITHABORT OFF 
GO
ALTER DATABASE [mineria_foretell] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [mineria_foretell] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [mineria_foretell] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [mineria_foretell] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [mineria_foretell] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [mineria_foretell] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [mineria_foretell] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [mineria_foretell] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [mineria_foretell] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [mineria_foretell] SET  DISABLE_BROKER 
GO
ALTER DATABASE [mineria_foretell] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [mineria_foretell] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [mineria_foretell] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [mineria_foretell] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [mineria_foretell] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [mineria_foretell] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [mineria_foretell] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [mineria_foretell] SET RECOVERY FULL 
GO
ALTER DATABASE [mineria_foretell] SET  MULTI_USER 
GO
ALTER DATABASE [mineria_foretell] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [mineria_foretell] SET DB_CHAINING OFF 
GO
ALTER DATABASE [mineria_foretell] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [mineria_foretell] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [mineria_foretell] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'mineria_foretell', N'ON'
GO
USE [mineria_foretell]
GO
/****** Object:  Table [dbo].[estimated_profit]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[estimated_profit](
	[e_id] [int] IDENTITY(1,1) NOT NULL,
	[mine_id] [int] NULL,
	[mining_cost] [varchar](50) NULL,
	[expected_profit] [varchar](50) NULL,
 CONSTRAINT [PK_estimated_profit] PRIMARY KEY CLUSTERED 
(
	[e_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[file_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[file_details](
	[file_id] [int] IDENTITY(1,1) NOT NULL,
	[point_id] [int] NULL,
	[file_path] [varchar](255) NULL,
	[status] [varchar](1) NULL,
 CONSTRAINT [PK_file_details] PRIMARY KEY CLUSTERED 
(
	[file_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[login_info]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[login_info](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[role] [varchar](50) NULL,
 CONSTRAINT [PK_login_info] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[mineral_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mineral_details](
	[mineral_id] [int] IDENTITY(1,1) NOT NULL,
	[mine_id] [int] NULL,
	[expected_mineral] [int] NULL,
	[quantity] [int] NULL,
	[cost] [float] NULL,
 CONSTRAINT [PK_mineral_details] PRIMARY KEY CLUSTERED 
(
	[mineral_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[point_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[point_details](
	[task_point_id] [int] IDENTITY(1,1) NOT NULL,
	[task_id] [int] NULL,
	[point_id] [int] NULL,
 CONSTRAINT [PK_point_details] PRIMARY KEY CLUSTERED 
(
	[task_point_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[point_readings]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[point_readings](
	[reading_id] [int] IDENTITY(1,1) NOT NULL,
	[point_id] [int] NULL,
	[depth] [float] NULL,
	[expected_mineral] [varchar](50) NULL,
	[back_force] [float] NULL,
 CONSTRAINT [PK_point_readings] PRIMARY KEY CLUSTERED 
(
	[reading_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[project_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[project_details](
	[mine_id] [int] IDENTITY(1,1) NOT NULL,
	[mine_area] [varchar](50) NULL,
	[due_date] [date] NULL,
	[mine_name] [varchar](50) NULL,
	[user_id_from] [int] NULL,
	[company_name] [varchar](50) NULL,
	[points] [int] NULL,
	[tasks] [int] NULL,
	[project_name] [varchar](50) NULL,
 CONSTRAINT [PK_project_details] PRIMARY KEY CLUSTERED 
(
	[mine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[project_user_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[project_user_details](
	[project_user_id] [int] IDENTITY(1,1) NOT NULL,
	[mine_id] [int] NULL,
	[user_id_to] [int] NULL,
 CONSTRAINT [PK_project_user_details] PRIMARY KEY CLUSTERED 
(
	[project_user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[reading_report_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[reading_report_details](
	[report_id] [int] IDENTITY(1,1) NOT NULL,
	[mine_id] [int] NULL,
	[report_path] [varchar](50) NULL,
	[upload_date] [date] NULL,
 CONSTRAINT [PK_reading_report_details] PRIMARY KEY CLUSTERED 
(
	[report_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[task_details]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[task_details](
	[task_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id_from] [int] NULL,
	[user_id_to] [int] NULL,
	[mine_id] [int] NULL,
	[due_date] [date] NULL,
	[depth] [float] NULL,
 CONSTRAINT [PK_task_details] PRIMARY KEY CLUSTERED 
(
	[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user_info]    Script Date: 18-01-2016 19:07:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_info](
	[user_login_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[user_first_name] [varchar](50) NOT NULL,
	[user_last_name] [varchar](50) NOT NULL,
	[user_contact_number] [varchar](15) NOT NULL,
 CONSTRAINT [PK_user_info] PRIMARY KEY CLUSTERED 
(
	[user_login_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[project_details]  WITH CHECK ADD  CONSTRAINT [FK_project_details_proj] FOREIGN KEY([mine_id])
REFERENCES [dbo].[project_details] ([mine_id])
GO
ALTER TABLE [dbo].[project_details] CHECK CONSTRAINT [FK_project_details_proj]
GO
ALTER TABLE [dbo].[user_info]  WITH CHECK ADD  CONSTRAINT [FK_user_info_login_info] FOREIGN KEY([user_id])
REFERENCES [dbo].[login_info] ([user_id])
GO
ALTER TABLE [dbo].[user_info] CHECK CONSTRAINT [FK_user_info_login_info]
GO
USE [master]
GO
ALTER DATABASE [mineria_foretell] SET  READ_WRITE 
GO
