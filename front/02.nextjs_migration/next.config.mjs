/** @type {import('next').NextConfig} */
const isDev = process.env.NODE_ENV !== 'production';

const nextConfig = {
  async headers() {
    return isDev
      ? [
          {
            source: '/(.*)',
            headers: [
              { key: 'Cache-Control', value: 'no-store, no-cache, must-revalidate, proxy-revalidate' },
              { key: 'Pragma', value: 'no-cache' },
              { key: 'Expires', value: '0' },
            ],
          },
        ]
      : [];
  },
};

export default nextConfig;
