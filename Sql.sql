create table simple_user
(
    user_id int auto_increment not null comment '抖音用户id',
    user_email varchar(100) comment '用户邮箱',
    user_name varchar(100) comment '用户姓名',
    user_password varchar(100) comment '用户密码',
    user_follower_resume varchar(255)  comment '用户简介',
    user_avatar varchar(255) comment '用户头像',
    user_follow_count int comment '用户关注总数',
    user_follower_count int comment '粉丝总数',
    user_create_time DATE comment '创建时间',
    user_create_id int comment '创建用户id',
    user_modify_time DATE comment '修改时间',
    user_modify_id int comment '修改用户id',
    primary key (user_id),
    index simple_user_index(user_id)
)comment '抖音用户';

create table simple_video
(
    video_id bigint auto_increment not null comment '视频唯一标识',
    video_play_url  varchar(100) comment '视频封面地址',
    video_cover_url  int comment '视频封面地址',
    video_favorite_count int comment '视频的点赞总数',
    video_comment_count int comment '视频的评论总数',
    video_is_favorite boolean comment '是否点赞',
    video_title  varchar(100) comment '视频标题',
    video_create_time DATE comment '创建时间',
    video_create_id int comment '创建用户id',
    video_modify_time DATE comment '修改时间',
    video_modify_id int comment '修改用户id',
    primary key (video_id),
    index simple_video_index(video_id),
    index simple_video_user_index(video_create_id)
)comment '视频';


create table simple_follower
(
    follower_id int not null comment '粉丝用户id',
    follower_create_time DATE comment '关注时间',
    follower_user_id int comment '关注主播id',
    primary key (follower_id),
    index simple_follower_index(follower_id),
    index simple_follower_user_index(follower_user_id)
)comment '用户粉丝';

create table simple_video_action
(
    v_action_id bigint auto_increment not null comment '评论id',
    v_action_video_id bigint comment '评论视频id',
    v_action_type int comment '1-发布评论，2-删除评论',
    v_action_content longtext comment '评论内容',
    v_action_create_time DATE comment '评论发布日期',
    v_action_user_id int comment '评论用户id',
    primary key (v_action_id),
    index simple_action_index(v_action_id),
    index simple_action_video_id(v_action_user_id)
)comment '视频评论';

create table simple_message
(
    r_action_id bigint auto_increment not null comment '消息id',
    r_action_content longtext comment '消息内容',
    r_action_create_time DATETIME comment '消息发送日期',
    r_action_from_user_id int comment '发送用户id',
    r_action_to_user_id int comment '接收用户id',
    primary key (r_action_id),
    index simple_from_user_index(r_action_from_user_id),
    index simple_to_user_id(r_action_to_user_id)
)comment '用户聊天';

ALTER TABLE `simple_follower`
    ADD COLUMN `id` int UNSIGNED NOT NULL AUTO_INCREMENT FIRST,
    MODIFY COLUMN `follower_create_time` datetime NULL DEFAULT NULL COMMENT '关注时间' AFTER `follower_id`,
    MODIFY COLUMN `follower_user_id` int NOT NULL COMMENT '关注主播id' AFTER `follower_create_time`,
    DROP PRIMARY KEY,
    ADD PRIMARY KEY (`id`) USING BTREE;