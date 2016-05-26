package com.huihui.common.request;

/**
 * ImageLoader第三方库的工具类
 *
 * @author YangZhenshan
 */
public class ImageLoaderTools {

//    private static Handler mHandler = new Handler(Looper.getMainLooper());
//
//    private static ImageLoader mImageLoader;
//
//    private static ImageLoaderTools mImageLoaderTools;
//    /**
//     * 主线程id
//     */
//    private static long mUithreadid;
//
//    /**
//     * 初始化ImageLoader配置
//     *
//     * @param context
//     * @param cacheDirStr
//     */
//    public static void initImageLoader(Context context, String cacheDirStr) {
//        if (mImageLoader != null) {
//            ALog.w("ImageLoader has been initialed");
//            return;
//        }
//        File cacheDir = StorageUtils.getOwnCacheDirectory(context, cacheDirStr);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPoolSize(1)
//                // 线程池内加载的数量
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .memoryCache(new WeakMemoryCache())
//                // .denyCacheImageMultipleSizesInMemory()
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .diskCache(new UnlimitedDiskCache(new File(cacheDirStr)))
//                // 自定义缓存路径
//                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
//                .build();// 开始构建
//        ImageLoader.getInstance().init(config);
//        mImageLoader = ImageLoader.getInstance();
//        mUithreadid = Thread.currentThread().getId();
//
//    }
//
//    /**
//     * 列表中用到的图片加载配置
//     */
//    public static DisplayImageOptions getDisplayImageOptions() {
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.mipmap.common_default_img)
//                .resetViewBeforeLoading(true)
//                // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageForEmptyUri(R.mipmap.common_default_img)
//                // 设置图片加载/解码过程中错误时候显示的图片
//                .showImageOnFail(R.mipmap.common_default_img)
//                // .showImageOnLoading(R.drawable.default_img)
//                // 设置下载的图片是否缓存在内存中
//                .cacheInMemory(true)
//                // 设置下载的图片是否缓存在SD卡中
//                .cacheOnDisk(true)
//                // 设置图片以如何的编码方式显示
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
//                // 设置图片的解码类型
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                // .decodingOptions(android.graphics.BitmapFactory.Options
//                // decodingOptions)//设置图片的解码配置
//                // 设置图片下载前的延迟
//                // delayInMillis为你设置的延迟时间
//                .build();
//        return options;
//    }
//
//    /**
//     * 列表中用到的图片加载配置
//     */
//    public static DisplayImageOptions getDisplayImageOptions(int defaultImg) {
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(defaultImg)
//                .resetViewBeforeLoading(true)
//                // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageForEmptyUri(defaultImg)
//                // 设置图片加载/解码过程中错误时候显示的图片
//                .showImageOnFail(defaultImg)
//                // .showImageOnLoading(R.drawable.default_img)
//                // 设置下载的图片是否缓存在内存中
//                .cacheInMemory(true)
//                // 设置下载的图片是否缓存在SD卡中
//                .cacheOnDisk(true)
//                // 设置图片以如何的编码方式显示
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
//                // 设置图片的解码类型
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                // .decodingOptions(android.graphics.BitmapFactory.Options
//                // decodingOptions)//设置图片的解码配置
//                // 设置图片下载前的延迟
//                // delayInMillis为你设置的延迟时间
//                .build();
//        return options;
//    }
//
//
//    /**
//     * icon中用到的图片加载配置
//     */
//    public static DisplayImageOptions getUserIconImageOptions() {
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.mipmap.common_icon_user_default)
//                .resetViewBeforeLoading(true)
//                // 设置图片Uri为空或是错误的时候显示的图片
//                .showImageForEmptyUri(R.mipmap.common_icon_user_default)
//                // 设置图片加载/解码过程中错误时候显示的图片
//                .showImageOnFail(R.mipmap.common_icon_user_default)
//                // .showImageOnLoading(R.drawable.default_img)
//                // 设置下载的图片是否缓存在内存中
//                .cacheInMemory(true)
//                // 设置下载的图片是否缓存在SD卡中
//                .cacheOnDisk(true)
//                // 设置图片以如何的编码方式显示
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
//                // 设置图片的解码类型
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                // .decodingOptions(android.graphics.BitmapFactory.Options
//                // decodingOptions)//设置图片的解码配置
//                // 设置图片下载前的延迟
//                // delayInMillis为你设置的延迟时间
//                .delayBeforeLoading(200)// int
//                // 设置图片加入缓存前，对bitmap进行设置
//                // .preProcessor(BitmapProcessor preProcessor)
//                // .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
////				.displayer(new RoundedBitmapDisplayer(10))// 是否设置为圆角，弧度为多少
//                .displayer(new FadeInBitmapDisplayer(200))// 淡入
//                .build();
//        return options;
//    }
//
//    /**
//     * 加载图片 能解决错乱
//     *  @param uri       网址(本地:file:// 网络:http://)
//     * @param imageView 要加载图片的对象
//     */
//    public static void loadImage(final String uri, final ImageView imageView) {
//        if (mImageLoader == null) {
//            throw new RuntimeException("请先调用 initImageLoader进行初始化");
//        }
//        mImageLoader.displayImage(uri, new ImageViewAware(imageView) {
//
//
//            @Override
//            public boolean setImageBitmap(final Bitmap bitmap) {
//                if (imageView.getTag() != null && !imageView.getTag().equals(uri)) {
//                    // 如果uri不一致就不显示了
//                    return super.setImageBitmap(bitmap);
//                }
//                // 线程处理
//                if (Thread.currentThread().getId() != mUithreadid) {
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            imageView.setImageBitmap(bitmap);
//                        }
//                    });
//                } else {
//                    imageView.setImageBitmap(bitmap);
//                }
//
//                return true;
//            }
//        }, getDisplayImageOptions());
//    }
//
//    /**
//     * 加载头像
//     * @param url
//     * @param imageView
//     */
//    public static void loadIcon(String url ,ImageView imageView){
//        mImageLoader.displayImage(url,imageView,getUserIconImageOptions());
//    }
//    public static void displayImage(String url, ImageView imageView, DisplayImageOptions imageOptions){
//        if (mImageLoader == null) {
//            throw new RuntimeException("请先调用 initImageLoader进行初始化");
//        }
//        mImageLoader.displayImage(url, imageView, imageOptions);
//    }
}
