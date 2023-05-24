USE [master]
GO
/****** Object:  Database [Boxes]    Script Date: 5/24/2023 5:44:20 PM ******/
CREATE DATABASE [Boxes]
GO
ALTER DATABASE [Boxes] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Boxes].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Boxes] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Boxes] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Boxes] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Boxes] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Boxes] SET ARITHABORT OFF 
GO
ALTER DATABASE [Boxes] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Boxes] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Boxes] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Boxes] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Boxes] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Boxes] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Boxes] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Boxes] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Boxes] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Boxes] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Boxes] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Boxes] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Boxes] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Boxes] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Boxes] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Boxes] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Boxes] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Boxes] SET RECOVERY FULL 
GO
ALTER DATABASE [Boxes] SET  MULTI_USER 
GO
ALTER DATABASE [Boxes] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Boxes] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Boxes] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Boxes] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Boxes] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Boxes] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Boxes', N'ON'
GO
ALTER DATABASE [Boxes] SET QUERY_STORE = ON
GO
ALTER DATABASE [Boxes] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Boxes]
GO
/****** Object:  Table [dbo].[BOXES]    Script Date: 5/24/2023 5:44:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BOXES](
	[ID] [int] NOT NULL,
	[CODE] [nvarchar](255) NOT NULL,
	[SIZE] [nvarchar](255) NOT NULL,
	[BOOKED] [binary](1) NOT NULL,
	[Price] [int] NOT NULL,
	[LocationID] [int] NOT NULL,
 CONSTRAINT [PK_BOXES] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CLIENTS]    Script Date: 5/24/2023 5:44:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLIENTS](
	[ID] [int] NOT NULL,
	[NAME] [nchar](30) NULL,
	[SURNAME] [nchar](30) NULL,
	[PHONE] [varchar](30) NOT NULL,
	[REGULAR] [binary](1) NOT NULL,
	[EMAIL] [varchar](50) NULL,
 CONSTRAINT [PK_CLIENTS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 5/24/2023 5:44:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[ID] [int] NOT NULL,
	[Name] [varchar](20) NOT NULL,
 CONSTRAINT [PK_DEPARTMENT] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EMPLOYEE]    Script Date: 5/24/2023 5:44:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EMPLOYEE](
	[ID] [int] NOT NULL,
	[NAME] [nvarchar](255) NOT NULL,
	[SURNAME] [nvarchar](255) NOT NULL,
	[DEPARTMENTID] [int] NOT NULL,
	[POSITION] [nvarchar](255) NOT NULL,
	[PHONE] [varchar](30) NOT NULL,
	[SALARY] [varchar](30) NOT NULL,
	[ManagerID] [int] NULL,
	[PASSWORD] [varchar](32) NULL,
 CONSTRAINT [PK_EMPLOYEE] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Locations]    Script Date: 5/24/2023 5:44:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Locations](
	[ID] [int] NOT NULL,
	[BOXES_COUNT] [int] NOT NULL,
	[LOCATION_Address] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_LOCATIONS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ORDERS]    Script Date: 5/24/2023 5:44:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ORDERS](
	[ID] [int] NOT NULL,
	[CLIENTID] [int] NOT NULL,
	[EMLOYEEID] [int] NOT NULL,
	[BOXID] [int] NOT NULL,
	[START_DATE] [date] NOT NULL,
	[END_DATE] [date] NOT NULL,
	[SUM] [int] NOT NULL,
	[STATUS] [nchar](20) NULL,
 CONSTRAINT [PK_ORDERS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (1, N'СМ1', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (2, N'СМ2', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (3, N'СМ3', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (4, N'СМ4', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (5, N'СМ5', N'малий', 0x01, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (6, N'СВ6', N'великий', 0x01, 1150, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (7, N'СВ7', N'великий', 0x00, 1150, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (8, N'СВ8', N'великий', 0x00, 1150, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (9, N'СС9', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (10, N'СС10', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (11, N'СС11', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (12, N'СС12', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (13, N'СС13', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (14, N'СС14', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (15, N'СС15', N'середній', 0x00, 800, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (16, N'СМ16', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (17, N'СМ17', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (18, N'СМ18', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (19, N'СМ19', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (20, N'СМ20', N'малий', 0x00, 500, 1)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (21, N'ЗМ1', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (22, N'ЗМ2', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (23, N'ЗМ3', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (24, N'ЗМ4', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (25, N'ЗМ5', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (26, N'ЗМ6', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (27, N'ЗМ7', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (28, N'ЗМ8', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (29, N'ЗМ9', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (30, N'ЗМ10', N'малий', 0x00, 450, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (31, N'ЗМ11', N'малий', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (32, N'ЗМ12', N'малий', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (33, N'ЗМ13', N'малий', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (34, N'ЗС14', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (35, N'ЗС15', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (36, N'ЗС16', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (37, N'ЗС17', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (38, N'ЗС18', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (39, N'ЗС19', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (40, N'ЗС20', N'середній', 0x00, 700, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (41, N'ЗС21', N'середній', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (42, N'ЗС22', N'середній', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (43, N'ЗС23', N'середній', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (44, N'ЗВ24', N'великий', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (45, N'ЗВ25', N'великий', 0x01, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (46, N'ЗВ26', N'великий', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (47, N'ЗВ27', N'великий', 0x01, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (48, N'ЗВ28', N'великий', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (49, N'ЗВ29', N'великий', 0x00, 1000, 2)
INSERT [dbo].[BOXES] ([ID], [CODE], [SIZE], [BOOKED], [Price], [LocationID]) VALUES (50, N'ЗВ30', N'великий', 0x00, 1000, 2)
GO
INSERT [dbo].[CLIENTS] ([ID], [NAME], [SURNAME], [PHONE], [REGULAR], [EMAIL]) VALUES (1, N'Оксана                        ', N'Галушко                       ', N'0973271149', 0x00, N'o.galushko@gmail.com')
INSERT [dbo].[CLIENTS] ([ID], [NAME], [SURNAME], [PHONE], [REGULAR], [EMAIL]) VALUES (2, N'Григорій                      ', N'Бойко                         ', N'0960959090', 0x00, N'gboyko12@gmail.com')
INSERT [dbo].[CLIENTS] ([ID], [NAME], [SURNAME], [PHONE], [REGULAR], [EMAIL]) VALUES (3, N'Василь                        ', N'Суджич                        ', N'0952293221', 0x00, N'vsc1112@gmail.com')
INSERT [dbo].[CLIENTS] ([ID], [NAME], [SURNAME], [PHONE], [REGULAR], [EMAIL]) VALUES (4, N'Іван                          ', N'Антонюк                       ', N'0969702451', 0x00, N'ivaa@ukr.net')
INSERT [dbo].[CLIENTS] ([ID], [NAME], [SURNAME], [PHONE], [REGULAR], [EMAIL]) VALUES (5, N'Назар                         ', N'Мазур                         ', N'0960920894', 0x00, N'nazar.mazur@ukr.net')
GO
INSERT [dbo].[Department] ([ID], [Name]) VALUES (1, N'Sales')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (2, N'Managment')
GO
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (0, N' Не призначено', N' Не призначено', 1, N' Не призначено', N'0900900900', N'0', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (1, N'Олександр', N'Петренко', 1, N'Менеджер', N'0931234567', N'20000', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (2, N'Ірина', N'Григоренко', 1, N'Менеджер', N'0502345678', N'25000', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (3, N'Сергій', N'Ковальчук', 1, N'Менеджер', N'0673456789', N'28000', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (4, N'Андрій', N'Ковальов', 1, N'Технік', N'0934567890', N'15000', 1, N'61bd60c60d9fb60cc8fc7767669d40a1')
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (5, N'Юлія', N'Пономаренко', 1, N'Технік', N'0505678901', N'12000', 1, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (6, N'Денис', N'Шевчук', 1, N'Технік', N'0676789012', N'13000', 1, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (7, N'Олег', N'Михайленко', 1, N'Технік', N'0937890123', N'14000', 1, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (8, N'Оксана', N'Кравченко', 1, N'Технік', N'0508901234', N'15000', 1, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (9, N'Віктор', N'Іванов', 1, N'Технік', N'0679012345', N'14000', 2, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (10, N'Алла', N'Сидоренко', 1, N'Технік', N'0930123456', N'13000', 2, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (11, N'Ігор', N'Мельник', 1, N'Технік', N'0501234567', N'16000', 2, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (12, N'Марина', N'Коваленко', 1, N'Технік', N'0672345678', N'17000', 2, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (13, N'Роман', N'Лисенко', 1, N'Технік', N'0933456789', N'18000', 2, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (14, N'Надія', N'Малицька', 1, N'Бухгалтер', N'0504567890', N'22000', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (15, N'Олег', N'Білецький', 1, N'Юрист', N'0673261218', N'25000', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (16, N'Олена', N'Мельник', 2, N'Менеджер', N'0661234567', N'28000', NULL, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (17, N'Антон', N'Ковальчук', 2, N'Технік', N'0501111111', N'15000', 16, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (18, N'Олег', N'Мельник', 2, N'Технік', N'0502222222', N'14000', 16, NULL)
INSERT [dbo].[EMPLOYEE] ([ID], [NAME], [SURNAME], [DEPARTMENTID], [POSITION], [PHONE], [SALARY], [ManagerID], [PASSWORD]) VALUES (19, N'Андрій', N'Литвин', 2, N'Технік', N'0503333333', N'13000', 16, NULL)
GO
INSERT [dbo].[Locations] ([ID], [BOXES_COUNT], [LOCATION_Address]) VALUES (1, 20, N'м. Львів, вул. Складська 15')
INSERT [dbo].[Locations] ([ID], [BOXES_COUNT], [LOCATION_Address]) VALUES (2, 30, N'м. Львів вул. Зберігальна 1')
GO
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (1, 1, 4, 5, CAST(N'2023-05-23' AS Date), CAST(N'2023-05-24' AS Date), 6000, N'Активне             ')
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (2, 2, 4, 45, CAST(N'2023-05-23' AS Date), CAST(N'2023-11-24' AS Date), 6000, N'Активне             ')
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (3, 3, 4, 45, CAST(N'2023-05-23' AS Date), CAST(N'2024-04-24' AS Date), 11000, N'Активне             ')
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (4, 3, 4, 46, CAST(N'2023-05-23' AS Date), CAST(N'2024-05-24' AS Date), 12000, N'Скасоване           ')
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (5, 3, 4, 46, CAST(N'2023-05-23' AS Date), CAST(N'2024-05-24' AS Date), 12000, N'Скасоване           ')
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (6, 4, 0, 47, CAST(N'2023-05-23' AS Date), CAST(N'2024-05-24' AS Date), 12000, N'Не оброблено        ')
INSERT [dbo].[ORDERS] ([ID], [CLIENTID], [EMLOYEEID], [BOXID], [START_DATE], [END_DATE], [SUM], [STATUS]) VALUES (7, 5, 4, 6, CAST(N'2023-05-24' AS Date), CAST(N'2023-09-25' AS Date), 4600, N'Активне             ')
GO
ALTER TABLE [dbo].[BOXES]  WITH CHECK ADD  CONSTRAINT [BOXES_fk0] FOREIGN KEY([LocationID])
REFERENCES [dbo].[Locations] ([ID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[BOXES] CHECK CONSTRAINT [BOXES_fk0]
GO
ALTER TABLE [dbo].[EMPLOYEE]  WITH CHECK ADD  CONSTRAINT [EMPLOYEE_fk0] FOREIGN KEY([DEPARTMENTID])
REFERENCES [dbo].[Department] ([ID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[EMPLOYEE] CHECK CONSTRAINT [EMPLOYEE_fk0]
GO
ALTER TABLE [dbo].[EMPLOYEE]  WITH CHECK ADD  CONSTRAINT [EMPLOYEE_fk1] FOREIGN KEY([ManagerID])
REFERENCES [dbo].[EMPLOYEE] ([ID])
GO
ALTER TABLE [dbo].[EMPLOYEE] CHECK CONSTRAINT [EMPLOYEE_fk1]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [ORDERS_fk0] FOREIGN KEY([CLIENTID])
REFERENCES [dbo].[CLIENTS] ([ID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [ORDERS_fk0]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [ORDERS_fk1] FOREIGN KEY([EMLOYEEID])
REFERENCES [dbo].[EMPLOYEE] ([ID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [ORDERS_fk1]
GO
ALTER TABLE [dbo].[ORDERS]  WITH CHECK ADD  CONSTRAINT [ORDERS_fk2] FOREIGN KEY([BOXID])
REFERENCES [dbo].[BOXES] ([ID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ORDERS] CHECK CONSTRAINT [ORDERS_fk2]
GO
USE [master]
GO
ALTER DATABASE [Boxes] SET  READ_WRITE 
GO
