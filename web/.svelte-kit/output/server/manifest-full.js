export const manifest = (() => {
function __memo(fn) {
	let value;
	return () => value ??= (value = fn());
}

return {
	appDir: "_app",
	appPath: "_app",
	assets: new Set(["favicon.png"]),
	mimeTypes: {".png":"image/png"},
	_: {
		client: {"start":"_app/immutable/entry/start.DQxTrPsp.js","app":"_app/immutable/entry/app.DmfF-_Dp.js","imports":["_app/immutable/entry/start.DQxTrPsp.js","_app/immutable/chunks/entry.DaIJGEIz.js","_app/immutable/chunks/runtime.DgFCWXxz.js","_app/immutable/entry/app.DmfF-_Dp.js","_app/immutable/chunks/runtime.DgFCWXxz.js","_app/immutable/chunks/store.BVe0zDLp.js","_app/immutable/chunks/disclose-version.B6Sji2Jz.js"],"stylesheets":[],"fonts":[],"uses_env_dynamic_public":false},
		nodes: [
			__memo(() => import('./nodes/0.js')),
			__memo(() => import('./nodes/1.js')),
			__memo(() => import('./nodes/2.js'))
		],
		routes: [
			{
				id: "/",
				pattern: /^\/$/,
				params: [],
				page: { layouts: [0,], errors: [1,], leaf: 2 },
				endpoint: null
			}
		],
		matchers: async () => {
			
			return {  };
		},
		server_assets: {}
	}
}
})();
