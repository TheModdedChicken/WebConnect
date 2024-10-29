

export const index = 2;
let component_cache;
export const component = async () => component_cache ??= (await import('../entries/pages/_page.svelte.js')).default;
export const imports = ["_app/immutable/nodes/2.CGlK4GJF.js","_app/immutable/chunks/disclose-version.B6Sji2Jz.js","_app/immutable/chunks/runtime.DgFCWXxz.js"];
export const stylesheets = [];
export const fonts = [];
